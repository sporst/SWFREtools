package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ShapeWithStyleParser {

	public static ShapeWithStyle parse(final BinaryParser parser) {

		final FillStyleArray fillStyles = FillStyleArrayParser.parse(parser);
		final LineStyleArray lineStyles = LineStyleArrayParser.parse(parser);
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits);

		return new ShapeWithStyle(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);

	}

}
