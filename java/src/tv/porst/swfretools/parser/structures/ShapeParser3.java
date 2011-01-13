package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeParser3 {

	public static Shape3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord3 shapeRecord = ShapeRecordParser3.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new Shape3(numFillBits, numLineBits, shapeRecord);
	}

}
