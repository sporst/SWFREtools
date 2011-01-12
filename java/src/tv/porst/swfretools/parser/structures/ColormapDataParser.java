package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ColormapDataParser {

	public static ColormapData parse(final SWFBinaryParser parser, final int colorTableSize, final int imageDataSize) throws SWFParserException {
		final RGB[] colorTableRGB = new RGB[colorTableSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBParser.parse(parser, String.format("ColorTableRGB[%d]", i));
		}

		final byte[] colormapPixelData = BinaryParserHelpers.readByteArray(parser, imageDataSize);

		return new ColormapData(colorTableRGB, colormapPixelData);
	}

	public static ColormapData parseIf(final SWFBinaryParser parser, final boolean condition, final int colorTableSize, final int imageDataSize) throws SWFParserException {
		return condition ? parse(parser, colorTableSize, imageDataSize) : null;
	}

}
