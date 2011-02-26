package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ItemInfoParser {

	public static ItemInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 key = EncodedU30Parser.parse(parser, fieldName + "::key");
		final EncodedU30 value = EncodedU30Parser.parse(parser, fieldName + "::value");

		return new ItemInfo(key, value);
	}
}
