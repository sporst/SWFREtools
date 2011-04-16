package tv.porst.swfretools.minimizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tv.porst.splib.arrays.ArrayHelpers;
import tv.porst.splib.io.FileHelpers;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.utils.TagNames;

/**
 * This program can be used to minimize crashing SWF files. It does so by removing
 * tags from an input SWF file until the crash disappears.
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
	 * 
	 * @param flashPlayer The Flash Player executable to be used to execute the file.
	 * @param flashFile The name of the SWF file to execute.
	 * @param waitPeriod Number of milliseconds to wait for a crash.
	 * 
	 * @throws MinimizerException Thrown if removing the tags failed.
	 */
	private static void removeTags(final String flashPlayer, final String flashFile, final int waitPeriod) throws MinimizerException {

		File inputFile = new File(flashFile);
		final File parentDirectory = inputFile.getParentFile();
		final String filename = FileHelpers.extractFilename(inputFile.getAbsolutePath());

		boolean hasChanged = true;
		int iterationCounter = 1;

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

			// To remove tags, we are also loading the raw byte data of the
			// input file.
			byte[] fileData;

			try {
				fileData = FileHelpers.readFile(inputFile);
			} catch (final IOException e) {
				throw new MinimizerException("SWF input file could not be read");
			}

			// For each run of the minimizer loop, this list stores
			// the tags that can be removed without the input file
			// crashing.
			final List<Tag> removableTags = new ArrayList<Tag>();

			// Inner loop: Remove one tag at a time and then check
			// whether the modified file still crashes.
			for (final Tag tag : parsedFile.getTags()) {

				System.out.printf("Trying to remove tag %s at offset %08X\n", TagNames.getTagName(tag.getHeader().getTagCode()), tag.getBitPosition() / 8);

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
				}
			}

			System.out.printf("Iteration %d complete\n", iterationCounter);

			if (removableTags.isEmpty()) {
				System.out.println("No more tags could be removed.");
			}
			else {
				System.out.println("The following tags will be removed in this iteration:");
			}

			for (final Tag tag : removableTags) {
				System.out.printf("%08X: %s\n", tag.getBitPosition() / 8, TagNames.getTagName(tag.getHeader().getTagCode()));
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
			iterationCounter++;
		}
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

		final String newFilename = parentDirectory.getAbsolutePath() + File.separator + filename + "." + iterationCounter;

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
	public static void main(String[] args) {

		args = new String[] { "C:\\@@\\flashplayer_10_sa.exe", "C:\\@@\\survey-questions_2011.swf"};

		if (args.length != 2) {

			System.out.println("Usage: minimizer <flashplayer.exe> <flashfile.swf>");
			return;
		}

		final String flashPlayer = args[0];
		final String flashFile = args[1];
		final int waitPeriod = 5000;

		System.out.printf("Minimizing SWF file %s with player %s\n", flashPlayer, flashFile);

		try {
			removeTags(flashPlayer, flashFile, waitPeriod);

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