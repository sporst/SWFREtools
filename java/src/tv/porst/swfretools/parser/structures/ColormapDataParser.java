package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;

public class ColormapDataParser {

	public static ColormapData parse(final BinaryParser parser, final int colorTableSize, final int imageDataSize) {
		final RGB[] colorTableRGB = new RGB[colorTableSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBParser.parse(parser);
		}

		final byte[] colormapPixelData = BinaryParserHelpers.readByteArray(parser, imageDataSize);

		return new ColormapData(colorTableRGB, colormapPixelData);
	}

}
