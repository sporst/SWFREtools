package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class OptionDetailParser {

	public static OptionDetail parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 val = EncodedU30Parser.parse(parser, fieldName + "::val");
		final UINT8 kind = parseUINT8(parser, 0x00006, fieldName + "::kind");

		return new OptionDetail(val, kind);
	}
}