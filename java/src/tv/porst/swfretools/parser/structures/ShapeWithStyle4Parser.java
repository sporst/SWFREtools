package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ShapeWithStyle4Parser {

	public static ShapeWithStyle4 parse(final BinaryParser parser) {
		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser);
		final LineStyle4Array lineStyles = LineStyle4ArrayParser.parse(parser);
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits);

		return new ShapeWithStyle4(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);
	}

}
