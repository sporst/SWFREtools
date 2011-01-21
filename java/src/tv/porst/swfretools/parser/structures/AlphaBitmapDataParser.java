package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class AlphaBitmapDataParser {

	public static AlphaBitmapData parse(final SWFBinaryParser parser, final int imageDataSize) throws SWFParserException {
		final RGBA[] colorTableRGB = new RGBA[imageDataSize];

		for (int i=0;i<colorTableRGB.length;i++) {
			colorTableRGB[i] = RGBAParser.parse(parser, String.format("ColorTableRGB[%d]", i));
		}

		return new AlphaBitmapData(colorTableRGB);
	}

	public static AlphaBitmapData parseIf(final SWFBinaryParser parser, final boolean condition, final int imageDataSize) throws SWFParserException {
		return condition ? parse(parser, imageDataSize) : null;
	}

}
