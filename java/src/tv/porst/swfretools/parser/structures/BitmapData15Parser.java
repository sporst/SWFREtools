package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class BitmapData15Parser {

	public static BitmapData15 parse(final SWFBinaryParser parser, final int imageDataSize, final String fieldName) throws SWFParserException {
		final Pix15[] bitmapPixelData = new Pix15[imageDataSize / 2];

		for (int i=0;i<bitmapPixelData.length;i++) {
			bitmapPixelData[i] = Pix15Parser.parse(parser, String.format(fieldName + "::BitmapPixelData[%d]", i));
		}

		return new BitmapData15(bitmapPixelData);
	}

	public static BitmapData15 parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, imageDataSize, fieldName) : null;
	}

}
