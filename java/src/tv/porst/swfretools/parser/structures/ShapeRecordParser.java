package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ShapeRecordParser {

	public static ShapeRecord parse(final BinaryParser parser, final int fillBits, final int lineBits) {

		final int first6 = parser.peekBits(6);

		if (first6 == 0) {
			return EndShapeRecordParser.parse(parser);
		}
		else if ((first6 & 0x20) == 0x20) {
			return StyleChangeRecordParser.parse(parser, fillBits, lineBits);
		}
		else if ((first6 & 0x10) == 0x10) {
			return StraightEdgeRecordParser.parse(parser);
		}
		else {
			return CurvedEdgeRecordParser.parse(parser);
		}

	}

}
