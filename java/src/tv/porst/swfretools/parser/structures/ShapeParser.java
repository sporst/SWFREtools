package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeParser {

	public static Shape parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new Shape(numFillBits, numLineBits, shapeRecord);
	}

}
