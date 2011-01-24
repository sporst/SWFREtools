package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class BlurFilterParser {

	public static BlurFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final Fixed blurX = FixedParser.parse(parser, fieldName + "::BlurX");
		final Fixed blurY = FixedParser.parse(parser, fieldName + "::BlurY");
		final Bits passes = parser.readBits(5);
		final Bits reserved = parser.readBits(3);

		return new BlurFilter(blurX, blurY, passes, reserved);
	}

}
