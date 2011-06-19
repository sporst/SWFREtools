package tv.porst.swfretools.utils;

import java.io.File;
import java.io.IOException;

import tv.porst.splib.file.FileHelpers;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;


/**
 * Decompresses compressed SWF files.
 */
public final class Decompressor {

	/**
	 * Decompresses compressed SWF files and writes the output file to disk.
	 * 
	 * @param inputFile The compressed input SWF file.
	 * @param outputFile The decompressed output SWF file.
	 */
	public static void decompress(final String inputFile, final String outputFile) {

		if (inputFile == null) {
			throw new IllegalArgumentException("Input file argument must not be null.");
		}

		if (outputFile == null) {
			throw new IllegalArgumentException("Output file argument must not be null.");
		}

		try {
			final SWFFile swfFile = SWFParser.parse(new File(inputFile));

			if (!swfFile.getWasCompressed()) {
				System.out.println("Input file is already decompressed");
				return;
			}

			try {
				FileHelpers.writeFile(new File(outputFile), swfFile.getDecompressedData());
			} catch (final IOException e) {
				System.out.println("Error: Could not write to output file");
			}
		} catch (final IOException e) {
			System.out.println("Error: Could not read input file");
		} catch (final SWFParserException e) {
			System.out.println("Error: Could not parse input file");
		}
	}
}