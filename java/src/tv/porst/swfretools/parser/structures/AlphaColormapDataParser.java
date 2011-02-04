package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Parses AlphaColormapData structures.
 * 
 * @author sp
 */
public final class AlphaColormapDataParser {

	/**
	 * Parses an AlphaColormap structure.
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
	public static AlphaColormapData parse(final SWFBinaryParser parser, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {

		final RGBA[] colorTableRGB = new RGBA[colorTableSize + 1];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser, String.format(fieldName + "::ColorTableRGB[%d]", i));
		}

		final ByteArray colormapPixelData = SWFParserHelpers.parseByteArray(parser, imageDataSize, 0x00006, fieldName + "::ColormapPixelData");

		return new AlphaColormapData(colorTableRGB, colormapPixelData);
	}

	/**
	 * Parses an AlphaColormap structure if a condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true.
	 * @param colorTableSize Size of the color table.
	 * @param imageDataSize Size of the image data.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static AlphaColormapData parseIf(final SWFBinaryParser parser, final boolean condition, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, colorTableSize, imageDataSize, fieldName) : null;
	}
}