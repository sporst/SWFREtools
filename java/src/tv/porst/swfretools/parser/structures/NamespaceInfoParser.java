package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class NamespaceInfoParser {

	public static NamespaceInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 kind = parseUINT8(parser, 0x00006, fieldName + "::kind");
		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");

		return new NamespaceInfo(kind, name);
	}

}
