package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ShapeParser {

	public static Shape parse(final BinaryParser parser) {
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits);

		return new Shape(numFillBits, numLineBits, shapeRecord);
	}

}
