package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeRecordParser3 {

	public static ShapeRecord3 parse(final SWFBinaryParser parser, final int fillBits, final int lineBits, final String fieldName) throws SWFParserException {
		final int first6 = parser.peekBits(6);

		if (first6 == 0) {
			return EndShapeRecordParser.parse(parser);
		}
		else if ((first6 & 0x20) == 0x20) {
			return StyleChangeRecord3Parser.parse(parser, fillBits, lineBits, fieldName);
		}
		else if ((first6 & 0x10) == 0x10) {
			return StraightEdgeRecordParser.parse(parser);
		}
		else {
			return CurvedEdgeRecordParser.parse(parser);
		}
	}
}
