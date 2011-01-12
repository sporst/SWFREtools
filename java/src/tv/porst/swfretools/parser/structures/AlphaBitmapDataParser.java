package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.SWFBinaryParser;

public class AlphaBitmapDataParser {

	public static AlphaBitmapData parse(final BinaryParser parser, final int imageDataSize) {
		final RGBA[] colorTableRGB = new RGBA[imageDataSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser);
		}

		return new AlphaBitmapData(colorTableRGB);
	}

	public static AlphaBitmapData parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize) {
		return condition ? parse(parser, imageDataSize) : null;
	}

}
