package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class AlphaBitmapDataParser {

	public static AlphaBitmapData parse(final BinaryParser parser, final int imageDataSize) {
		final RGBA[] colorTableRGB = new RGBA[imageDataSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser);
		}

		return new AlphaBitmapData(colorTableRGB);
	}

}
