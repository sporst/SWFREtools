package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses BitmapData15 structures.
 * 
 * @author sp
 */
public final class BitmapData15Parser {

	/**
	 * Parses a BitmapData15 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param imageDataSize The size in bytes of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static BitmapData15 parse(final SWFBinaryParser parser, final int imageDataSize, final String fieldName) throws SWFParserException {

		final Pix15[] bitmapPixelData = new Pix15[imageDataSize / 2];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = Pix15Parser.parse(parser, String.format(fieldName + "::BitmapPixelData[%d]", i));
		}

		return new BitmapData15(bitmapPixelData);
	}

	/**
	 * Parses a BitmapData15 structure if a condition is true.
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
	public static BitmapData15 parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, imageDataSize, fieldName) : null;
	}
}