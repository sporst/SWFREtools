package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class AlphaColormapDataParser {

	public static AlphaColormapData parse(final SWFBinaryParser parser, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {
		final RGBA[] colorTableRGB = new RGBA[colorTableSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser, String.format(fieldName + "::ColorTableRGB[%d]", i));
		}

		final byte[] colormapPixelData = BinaryParserHelpers.readByteArray(parser, imageDataSize);

		return new AlphaColormapData(colorTableRGB, colormapPixelData);
	}

	public static AlphaColormapData parseIf(final SWFBinaryParser parser, final boolean condition, final int colorTableSize, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, colorTableSize, imageDataSize, fieldName) : null;
	}

}
