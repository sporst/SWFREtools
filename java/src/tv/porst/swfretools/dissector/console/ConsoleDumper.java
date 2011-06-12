package tv.porst.swfretools.dissector.console;

import java.io.File;
import java.io.IOException;

import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.utils.SWFIterator;

/**
 * Class that can be used to dump the content of a SWF file to console.
 * 
 */
public final class ConsoleDumper {

	/**
	 * Dumps the content of a file to the console.
	 * 
	 * @param inputFile The input file.
	 * @param parsedFile The parsed input file.
	 */
	private static void dump(final File inputFile, final SWFFile parsedFile) {
		SWFIterator.visit(parsedFile, new ConsoleVisitor(inputFile));
	}

	/**
	 * Dumps the content of a file to the console.
	 * 
	 * @param filename Name of the file to dump.
	 */
	public static void dump(final String filename) {

		final File file = new File(filename);

		if (!file.exists()) {
			System.out.printf("Error: File %s does not exist\n", filename);
			return;
		}

		try {
			dump(file, SWFParser.parse(file));
		} catch (final IOException e) {
			System.out.println("Error: Input file could not be read");
			System.out.println(e);
		} catch (final SWFParserException e) {
			System.out.println("Error: Input file could not be parsed");
			System.out.println(e);
		}
	}
}