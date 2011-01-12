package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.structures.Pix24;
import tv.porst.swfretools.parser.structures.Pix24Parser;

public class BitmapData24Parser {

	public static BitmapData24 parse(final BinaryParser parser, final int imageDataSize) {
		final Pix24[] bitmapPixelData = new Pix24[imageDataSize / 4];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = Pix24Parser.parse(parser);
		}

		return new BitmapData24(bitmapPixelData);
	}

	public static BitmapData24 parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize) {
		return condition ? parse(parser, imageDataSize) : null;
	}

}
