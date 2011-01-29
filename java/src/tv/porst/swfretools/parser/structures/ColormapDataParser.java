package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Parses ColorMapData structures.
 * 
 * @author sp
 */
public final class ColormapDataParser {

	/**
	 * Parses a ColormapData structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param colorTableSize Size of the color table.
	 * @param imageDataSize Size of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ColormapData parse(final SWFBinaryParser parser, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {

		final RGB[] colorTableRGB = new RGB[colorTableSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBParser.parse(parser, String.format(fieldName + "ColorTableRGB[%d]", i));
		}

		final ByteArray colormapPixelData = SWFParserHelpers.parseByteArray(parser, imageDataSize, 0x00006, fieldName + "::ColormapPixelData");

		return new ColormapData(colorTableRGB, colormapPixelData);
	}

	/**
	 * Parses a ColormapData structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition Condition to be true for the structure to be parsed.
	 * @param colorTableSize Size of the color table.
	 * @param imageDataSize Size of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ColormapData parseIf(final SWFBinaryParser parser, final boolean condition, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, colorTableSize, imageDataSize, fieldName) : null;
	}
}