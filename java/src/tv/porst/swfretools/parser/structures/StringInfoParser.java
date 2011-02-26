package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class StringInfoParser {

	public static StringInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 size = EncodedU30Parser.parse(parser, fieldName + "::size");
		final AsciiString name = parseString(parser, (int) size.value(), 0x00006, fieldName + "::utf8");

		return new StringInfo(size, name);
	}
}
