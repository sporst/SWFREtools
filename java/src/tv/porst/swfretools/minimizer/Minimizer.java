package tv.porst.swfretools.minimizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tv.porst.splib.arrays.ArrayHelpers;
import tv.porst.splib.file.FileHelpers;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.as3.AS3InstructionList;
import tv.porst.swfretools.parser.actions.as3.AS3Nop;
import tv.porst.swfretools.parser.structures.AS3Code;
import tv.porst.swfretools.parser.structures.MethodBody;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.structures.TagList;
import tv.porst.swfretools.parser.tags.DoABCTag;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.utils.TagNames;

/**
 * This program can be used to minimize crashing SWF files. It does so by removing
 * tags from an input SWF file until the crash disappears and then returning to the
 * last known crash state. It also NOPs ActionScript code to remove all the code that
 * is not related to the crash.
 */
public final class Minimizer {

	/**
	 * Executes a SWF file identified by its file name and waits for a given amount
	 * of time to see whether the SWF file makes Flash Player crash.
	 * 
	 * @param flashPlayer The Flash Player executable to be used to execute the file.
	 * @param filename The name of the SWF file to execute.
	 * @param waitPeriod Number of milliseconds to wait for a crash.
	 * 
	 * @return A value that determines
	 */
	private static ExecutionResult executeFile(final String flashPlayer, final String filename, final int waitPeriod) {

		assert flashPlayer != null : "Path to Flash Player executable must not be null";
		assert filename != null : "Path to SWF file must not be null";

		final long time = System.currentTimeMillis();

		final ExecuterThread thread = new ExecuterThread(flashPlayer, filename);
		thread.start();

		while (!thread.isDone()) {

			if (System.currentTimeMillis() > time + waitPeriod) {

				thread.close();

				return ExecutionResult.NoCrash;
			}

			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				// Swallow this in good conscience
			}
		}

		return thread.exitValue() == 0 ? ExecutionResult.NoCrash : ExecutionResult.Crashed;
	}

	/**
	 * Finds all ActionScript 3 code fragments in a SWF file.
	 * 
	 * @param file The SWF file to look through.
	 * 
	 * @return The list of found code fragments.
	 */
	private static List<AS3Code> findAS3Code(final SWFFile file) {

		assert file != null : "File argument must not be null";

		final List<AS3Code> codeFragments = new ArrayList<AS3Code>();

		for (final Tag tag : file.getTags()) {

			if (tag instanceof DoABCTag) {
				final DoABCTag dtag = (DoABCTag) tag;

				for (final MethodBody methodBody : dtag.getAbcData().getMethodBodies()) {
					codeFragments.add(methodBody.getCode());
				}
			}
		}

		return codeFragments;
	}

	/**
	 * Determines the filename of a minimizer iteration output file.
	 * 
	 * @param parentDirectory Parent directory where the file is placed.
	 * @param filename Name of the original input file.
	 * @param iterationCounter Number of successful iterations.
	 * 
	 * @return The filename of the minimizer iteration output file.
	 */
	private static String getIterationFilename(final File parentDirectory, final String filename, final int iterationCounter) {

		assert parentDirectory != null : "Parent directory must not be null";
		assert parentDirectory.isDirectory() : "Parent directory must be a directory";
		assert filename != null : "File name must not be null";
		assert iterationCounter > 0 : "Iteration counter must be positive";

		return parentDirectory.getAbsolutePath() + File.separator + filename + "." + iterationCounter;
	}

	/**
	 * Determines the output directory used by the Minimizer to write the final
	 * result to.
	 * 
	 * @param inputFile The input file to be minimized.
	 * 
	 * @return The output directory.
	 */
	private static File getOutputDirectory(final File inputFile) {
		return inputFile.getParentFile() == null ? new File(".") : inputFile.getParentFile();
	}

	/**
	 * Determines whether an ActionScript 3 code fragment is noppable or not. A
	 * code fragment is noppable if it has at least two instructions (one plus the
	 * return instruction) and has not been nopped yet.
	 * 
	 * @param code The code fragment to check.
	 * 
	 * @return True, if the code fragment is noppable. False if it is not.
	 */
	private static boolean isNoppable(final AS3Code code) {

		assert code != null : "Code fragment must not be null";

		return code.getInstructions().size() > 1 && !isNopped(code);
	}

	/**
	 * Determines whether an ActionScript 3 code fragment is already nopped.
	 * This is the case if all instructions but the final return instructions
	 * are AS3 NOP instructions.
	 * 
	 * @param code The code fragment to check.
	 * 
	 * @return True, if the code fragment is nopped. False, otherwise.
	 */
	private static boolean isNopped(final AS3Code code) {

		assert code != null : "Code fragment must not be null";

		final AS3InstructionList instructions = code.getInstructions();

		for (int i=0;i<instructions.size() - 2; i++) {
			if (!(instructions.get(i) instanceof AS3Nop)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Replaces the code of an ActionScript 3 function with NOP instructions.
	 * All code is replaced with NOPs except for the final return.
	 * 
	 * @param fileData The file data that contains the code.
	 * @param code The code object to NOP.
	 * 
	 * @return A copy of the file data with the nopped code fragment.
	 */
	private static byte[] nopCode(final byte[] fileData, final AS3Code code) {

		assert fileData != null : "File data must not be null";
		assert code != null : "Code must not be null";

		final int SIZE_RETURN_INSTRUCTION = 1; // All return instructions are 1 byte

		final int startOffset = code.getBitPosition() / 8;
		final int length = (code.getBitLength() - SIZE_RETURN_INSTRUCTION) / 8;

		return ArrayHelpers.replaceData(fileData, startOffset, length, (byte) 0x02);
	}

	/**
	 * Overwrites a list of code fragments with NOP instructions.
	 * 
	 * @param fileData The file data that contains the code.
	 * @param codeToRemove The code fragments to NOP.
	 * 
	 * @return A copy of the file data with the nopped code fragments.
	 */
	private static byte[] nopCode(final byte[] fileData, final List<AS3Code> codeToRemove) {

		assert fileData != null : "File data must not be null";
		assert codeToRemove != null : "Code to remove list most not be null";
		assert !codeToRemove.isEmpty() : "Code to remove list must not be empty";

		byte[] newData = fileData;

		for (final AS3Code code : codeToRemove) {
			newData = nopCode(newData, code);
		}

		return newData;
	}

	/**
	 * Removes ActionScript 3 code from the input file until no more code can be removed.
	 * 
	 * @param flashPlayer The Flash Player executable to be used to execute the file.
	 * @param flashFile The name of the SWF file to execute.
	 * @param waitPeriod Number of milliseconds to wait for a crash.
	 * @param lastIteration The number of previously completed minimizer iterations.
	 * 
	 * @throws MinimizerException Thrown if removing the tags failed.
	 */
	private static void removeAS3Code(final String flashPlayer, final String flashFile, final int waitPeriod, final int lastIteration) throws MinimizerException {

		assert flashPlayer != null : "Flash Player must not be null";
		assert flashFile != null : "Flash file must not be null";
		assert waitPeriod >= 0 : "Wait period must not be negative";
		assert lastIteration >= 0 : "Last iteration must not be negative";

		File inputFile = new File(flashFile);
		final File parentDirectory = getOutputDirectory(inputFile);
		final String filename = FileHelpers.extractFilename(inputFile.getAbsolutePath());

		if (lastIteration != 0) {
			// There exists a modified input file with some tags removed already.
			inputFile = new File(getIterationFilename(parentDirectory, filename, lastIteration));
		}

		boolean hasChanged = true;
		int iterationCounter = lastIteration;

		// Outer loop: Repeat until any change produces a crash
		while (hasChanged)
		{
			SWFFile parsedFile;

			try {
				parsedFile = SWFParser.parse(inputFile);
			} catch (final IOException e) {
				throw new MinimizerException("SWF input file could not be read");
			} catch (final SWFParserException e) {
				throw new MinimizerException("SWF input file could not be parsed");
			}

			// To remove code, we are also loading the raw byte data of the
			// input file.
			byte[] fileData;

			try {
				fileData = FileHelpers.readFile(inputFile);
			} catch (final IOException e) {
				throw new MinimizerException("SWF input file could not be read");
			}

			// For each run of the minimizer loop, this list stores
			// the functions that can be removed with the input file
			// crashing.
			final List<AS3Code> removableCode = new ArrayList<AS3Code>();

			int codeSectionCounter = 1;
			final List<AS3Code> codeSections = findAS3Code(parsedFile);

			// Inner loop: Remove one function at a time and then check
			// whether the modified file still crashes.
			for (final AS3Code code : codeSections) {

				if (!isNoppable(code)) {
					// This code fragment can not be nopped, so just ignore it.
					codeSectionCounter++;
					continue;
				}

				System.out.printf("Trying to remove method body (%d of %d) at offset %08X ... ", codeSectionCounter, codeSections.size(), code.getBitPosition() / 8);

				final byte[] modifiedData = nopCode(fileData, code);

				// Write modified file to temp file
				String tempFilename;

				try {
					tempFilename = writeTempFile(modifiedData);
				} catch (final IOException e) {
					throw new MinimizerException("SWF input file could not be written");
				}

				// Execute modified file
				final ExecutionResult executionResult = executeFile(flashPlayer, tempFilename, waitPeriod);

				if (executionResult == ExecutionResult.Crashed) {
					removableCode.add(code);
					System.out.println("REMOVE");
				}
				else {
					System.out.println("KEEP");
				}

				codeSectionCounter++;
			}

			if (removableCode.isEmpty()) {
				System.out.println("No more code could be removed.");
				break;
			}
			else {
				iterationCounter++;

				System.out.printf("Iteration %d complete\n", iterationCounter);
				System.out.println("The following method bodies will be removed in this iteration:");
			}

			for (final AS3Code code : removableCode) {
				System.out.printf("\t%08X\n", code.getBitPosition() / 8);
			}

			final byte[] iterationData = nopCode(fileData, removableCode);

			// Write the result of the first iteration to the original
			// directory. This file is the input file for the next iteration.
			try {
				final String newFilename = saveIterationResult(iterationData, parentDirectory, filename, iterationCounter);
				inputFile = new File(newFilename);
			} catch (final IOException e) {
				throw new MinimizerException("Iteration result file could not be saved");
			}

			// TODO: Confirm that this file crashes too.

			hasChanged = !removableCode.isEmpty();
		}
	}

	/**
	 * Removes a list of tags from a SWF file.
	 * 
	 * @param fileData The binary data of the whole SWF file.
	 * @param tagsToRemove The tags to remove.
	 * 
	 * @return The binary data with the tags removed.
	 */
	private static byte[] removeTags(final byte[] fileData, final List<Tag> tagsToRemove) {

		assert fileData != null : "File data must not be null";
		assert tagsToRemove != null : "Tags to remove list most not be null";
		assert !tagsToRemove.isEmpty() : "Tags to remove list must not be empty";

		byte[] newData = fileData;

		// Remove all removable tags. We are doing this in reverse order
		// so that we do not have to take care of changing offsets.

		final ArrayList<Tag> reversedList = new ArrayList<Tag>(tagsToRemove);
		Collections.reverse(reversedList);

		for (final Tag tag : reversedList) {
			final int bytePosition = tag.getBitPosition() / 8;
			final int byteLength = tag.getHeader().getHeaderLength() + tag.getHeader().getNormalizedLength();

			newData = ArrayHelpers.removeData(newData, bytePosition, byteLength);
		}

		return newData;
	}

	/**
	 * Removes tags from the input file until no more tags can be removed.
	 * 
	 * @param flashPlayer The Flash Player executable to be used to execute the file.
	 * @param flashFile The name of the SWF file to execute.
	 * @param waitPeriod Number of milliseconds to wait for a crash.
	 * 
	 * @return The number of completed iterations.
	 * 
	 * @throws MinimizerException Thrown if removing the tags failed.
	 */
	private static int removeTags(final String flashPlayer, final String flashFile, final int waitPeriod) throws MinimizerException {

		assert flashPlayer != null : "Flash Player must not be null";
		assert flashFile != null : "Flash file must not be null";
		assert waitPeriod >= 0 : "Wait period must not be negative";

		File inputFile = new File(flashFile);
		final File parentDirectory = getOutputDirectory(inputFile);
		final String filename = FileHelpers.extractFilename(inputFile.getAbsolutePath());

		boolean hasChanged = true;
		int iterationCounter = 0;

		// Outer loop: Repeat until any change produces a crash
		while (hasChanged)
		{
			SWFFile parsedFile;

			try {
				parsedFile = SWFParser.parse(inputFile);
			} catch (final IOException e) {
				throw new MinimizerException("SWF input file could not be read");
			} catch (final SWFParserException e) {
				throw new MinimizerException("SWF input file could not be parsed");
			}

			final byte[] fileData = parsedFile.getDecompressedData();

			// For each run of the minimizer loop, this list stores
			// the tags that can be removed without the input file
			// crashing.
			final List<Tag> removableTags = new ArrayList<Tag>();

			final TagList tags = parsedFile.getTags();

			int tagCounter = 1;

			// Inner loop: Remove one tag at a time and then check
			// whether the modified file still crashes.
			for (final Tag tag : tags) {

				System.out.printf("Trying to remove tag %s (%d of %d) at offset %08X ... ", TagNames.getPrintableTagName(tag.getHeader().getTagCode()), tagCounter, tags.size(), tag.getBitPosition() / 8);

				final int startOffset = tag.getBitPosition() / 8;
				final int length = tag.getHeader().getHeaderLength() + tag.getHeader().getNormalizedLength();

				final byte[] modifiedData = ArrayHelpers.removeData(fileData, startOffset, length);

				// Write modified file to temp file
				String tempFilename;

				try {
					tempFilename = writeTempFile(modifiedData);
				} catch (final IOException e) {
					throw new MinimizerException("SWF input file could not be written");
				}

				// Execute modified file
				final ExecutionResult executionResult = executeFile(flashPlayer, tempFilename, waitPeriod);

				if (executionResult == ExecutionResult.Crashed) {
					removableTags.add(tag);
					System.out.println("REMOVE");
				}
				else {
					System.out.println("KEEP");
				}

				tagCounter++;
			}

			if (removableTags.isEmpty()) {
				System.out.println("No more tags could be removed.");
				break;
			}
			else {
				iterationCounter++;

				System.out.printf("Iteration %d complete\n", iterationCounter);
				System.out.println("The following tags will be removed in this iteration:");
			}

			for (final Tag tag : removableTags) {
				System.out.printf("\t%08X: %s\n", tag.getBitPosition() / 8, TagNames.getPrintableTagName(tag.getHeader().getTagCode()));
			}

			final byte[] iterationData = removeTags(fileData, removableTags);

			// Write the result of the first iteration to the original
			// directory. This file is the input file for the next iteration.
			try {
				final String newFilename = saveIterationResult(iterationData, parentDirectory, filename, iterationCounter);
				inputFile = new File(newFilename);
			} catch (final IOException e) {
				throw new MinimizerException("Iteration result file could not be saved");
			}

			// TODO: Confirm that this file crashes too.

			hasChanged = !removableTags.isEmpty();
		}

		return iterationCounter;
	}

	/**
	 * Saves the result of one successful tag removal iteration to a new file.
	 * 
	 * @param fileData The binary file data to write to the file.
	 * @param parentDirectory The directory where the new file will be placed.
	 * @param filename The name of the new file.
	 * @param iterationCounter The iteration counter.
	 * 
	 * @return The name of the new file.
	 * 
	 * @throws IOException Thrown if the iteration file could not be saved.
	 */
	private static String saveIterationResult(final byte[] fileData, final File parentDirectory, final String filename, final int iterationCounter) throws IOException {

		assert fileData != null : "File data must not be null";
		assert parentDirectory != null : "Parent directory must not be null";
		assert parentDirectory.isDirectory() : "Parent directory must be a directory";
		assert filename != null : "File name must not be null";
		assert iterationCounter > 0 : "Iteration counter must be positive";

		final String newFilename = getIterationFilename(parentDirectory, filename, iterationCounter);

		FileHelpers.writeFile(newFilename, fileData);

		return newFilename;
	}

	/**
	 * Writes binary data to a temp file.
	 * 
	 * @param fileData The data to write to the temp file.
	 * 
	 * @return The name of the temp file.
	 * 
	 * @throws IOException Thrown if the data could not be written to the temp file.
	 */
	private static String writeTempFile(final byte[] fileData) throws IOException {

		assert fileData != null : "File data must not be null";

		final File tempFile = File.createTempFile("minimizer", "swf");

		FileHelpers.writeFile(tempFile, fileData);

		return tempFile.getAbsolutePath();
	}

	/**
	 * Main function of the Minimizer program. The program requires at least two arguments.
	 * The first argument must be the path to the Flash Player executable that is used
	 * to determine whether a given SWF file crashes or not. The second argument must be
	 * the path to the SWF file to be minimized. Additional optional arguments are also
	 * available.
	 * 
	 * @param args The command line arguments passed to the program.
	 */
	public static void main(final String[] args) {

		if (args.length != 2) {

			System.out.println("Usage: minimizer <flashplayer.exe> <flashfile.swf>");
			return;
		}

		final String flashPlayer = args[0];
		final String flashFile = args[1];
		final int waitPeriod = 5000;

		System.out.printf("Minimizing SWF file %s with player %s\n", flashPlayer, flashFile);

		try {
			final int lastIteration = removeTags(flashPlayer, flashFile, waitPeriod);
			removeAS3Code(flashPlayer, flashFile, waitPeriod, lastIteration);

			// TODO: Remove AS2 code

			System.out.println("Minimization complete");
		} catch (final MinimizerException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Thread that is used to execute the Flash Player executable.
	 */
	private static class ExecuterThread extends Thread {

		/**
		 * The Flash Player executable to be used to execute the file.
		 */
		private final String flashPlayer;

		/**
		 * The name of the SWF file to execute.
		 */
		private final String filename;

		/**
		 * The Flash Player process.
		 */
		private Process process;

		/**
		 * Flag that indicates whether Flash Player has terminated or not.
		 */
		private boolean isDone = false;

		/**
		 * Creates a new executer thread.
		 * 
		 * @param flashPlayer The Flash Player executable to be used to execute the file.
		 * @param filename The name of the SWF file to execute.
		 */
		public ExecuterThread(final String flashPlayer, final String filename) {

			assert flashPlayer != null : "Path to Flash Player executable must not be null";
			assert filename != null : "Path to SWF file must not be null";

			this.flashPlayer = flashPlayer;
			this.filename = filename;
		}

		/**
		 * Tells the thread to shut down Flash Player.
		 */
		public void close() {
			process.destroy();
		}

		/**
		 * Returns the exit value of the Flash Player process.
		 * 
		 * @return The exit value of the Flash Player process.
		 */
		public int exitValue() {
			return process.exitValue();
		}

		/**
		 * Returns whether the Flash Player process has terminated or not.
		 * 
		 * @return True, if the Flash Player process has terminated. False, otherwise.
		 */
		public boolean isDone() {
			return isDone;
		}

		@Override
		public void run() {
			final ProcessBuilder builder = new ProcessBuilder(flashPlayer, filename);

			try {
				process = builder.start();

				try {
					process.waitFor();
				} catch (final InterruptedException e) {
					// Silently swallow this
				}

			} catch (final IOException e) {
				e.printStackTrace();
			}

			isDone = true;
		}
	}

	/**
	 * Enum used to signal the execution result of a Flash Player run.
	 */
	private enum ExecutionResult {

		/**
		 * Flash Player crashed.
		 */
		Crashed,

		/**
		 * Flash Player did not crash.
		 */
		NoCrash
	}

	/**
	 * Exception class used to signal problems during minimization.
	 */
	private static class MinimizerException extends Exception {

		/**
		 * Creates a new exception object.
		 * 
		 * @param msg The exception message.
		 */
		public MinimizerException(final String msg) {
			super(msg);
		}
	}
}