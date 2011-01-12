package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.SWFBinaryParser;

public class BitmapData15Parser {

	public static BitmapData15 parse(final BinaryParser parser, final int imageDataSize) {
		final Pix15[] bitmapPixelData = new Pix15[imageDataSize / 2];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = Pix15Parser.parse(parser);
		}

		return new BitmapData15(bitmapPixelData);
	}

	public static BitmapData15 parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize) {
		return condition ? parse(parser, imageDataSize) : null;
	}

}
