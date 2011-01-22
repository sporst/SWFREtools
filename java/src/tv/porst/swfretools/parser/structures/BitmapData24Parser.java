package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class BitmapData24Parser {

	public static BitmapData24 parse(final SWFBinaryParser parser, final int imageDataSize, final String fieldName) throws SWFParserException {
		final Pix24[] bitmapPixelData = new Pix24[imageDataSize / 4];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = Pix24Parser.parse(parser, String.format(fieldName + "::BitmapPixelData[%d]", i));
		}

		return new BitmapData24(bitmapPixelData);
	}

	public static BitmapData24 parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, imageDataSize, fieldName) : null;
	}

}
