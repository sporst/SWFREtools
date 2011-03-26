package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MultinameInfoParser {

	private static IMultiname parseData(final SWFBinaryParser parser, final UINT8 kind, final String fieldName) throws SWFParserException {
		switch(kind.value()) {
		case 0x07: return QNameParser.parse(parser, fieldName);
		case 0x0D: return QNameAParser.parse(parser, fieldName);
		case 0x0F: return RTQNameParser.parse(parser, fieldName);
		case 0x10: return RTQNameAParser.parse(parser, fieldName);
		case 0x11: return RTQNameLParser.parse(parser, fieldName); // TODO: Should be null
		case 0x12: return RTQNameLAParser.parse(parser, fieldName); // TODO: Should be null
		case 0x09: return MultinameParser.parse(parser, fieldName);
		case 0x0E: return MultinameAParser.parse(parser, fieldName);
		case 0x1B: return MultinameLParser.parse(parser, fieldName);
		case 0x1C: return MultinameLAParser.parse(parser, fieldName);
		default: throw new IllegalStateException("Invalid multiname type");
		}
	}

	public static MultinameInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 kind = parseUINT8(parser, 0x00006, fieldName + "::kind");
		final IMultiname data = parseData(parser, kind, fieldName + "::data");

		return new MultinameInfo(kind, data);
	}
}