package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.SWFBinaryParser;

public class AlphaColormapDataParser {

	public static AlphaColormapData parse(final BinaryParser parser, final int colorTableSize, final int imageDataSize) {
		final RGBA[] colorTableRGB = new RGBA[colorTableSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser);
		}

		final byte[] colormapPixelData = BinaryParserHelpers.readByteArray(parser, imageDataSize);

		return new AlphaColormapData(colorTableRGB, colormapPixelData);
	}

	public static AlphaColormapData parseIf(final SWFBinaryParser parser, final boolean condition, final int colorTableSize, final int imageDataSize) {
		return condition ? parse(parser, colorTableSize, imageDataSize) : null;
	}

}
