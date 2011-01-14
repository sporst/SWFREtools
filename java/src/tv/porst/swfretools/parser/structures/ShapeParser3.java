package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeParser3 {

	public static Shape3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final Bits numFillBits = parseBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final ShapeRecord3 shapeRecord = ShapeRecordParser3.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new Shape3(numFillBits, numLineBits, shapeRecord);
	}

}
