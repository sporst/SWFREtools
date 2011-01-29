package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses AlphaBitmapData structures.
 * 
 * @author sp
 */
public final class AlphaBitmapDataParser {

	/**
	 * Parses an AlphaBitmapData structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param imageDataSize The size in bytes of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static AlphaBitmapData parse(final SWFBinaryParser parser, final int imageDataSize, final String fieldName) throws SWFParserException {

		final ARGB[] bitmapPixelData = new ARGB[imageDataSize];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = ARGBParser.parse(parser, String.format("BitmapPixelData[%d]", i));
		}

		return new AlphaBitmapData(bitmapPixelData);
	}

	/**
	 * Parses an AlphaBitmapData structure if a condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true for the structure to be parsed.
	 * @param imageDataSize The size in bytes of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static AlphaBitmapData parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, imageDataSize, fieldName) : null;
	}
}