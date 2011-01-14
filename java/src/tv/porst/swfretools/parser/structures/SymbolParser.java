package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class SymbolParser {

	public static Symbol parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 tag = parseUINT16(parser, 0x00006, fieldName + "::Tag");
		final PString name = parseString(parser, 0x00006, fieldName + "::Name");

		return new Symbol(tag, name);
	}

}
