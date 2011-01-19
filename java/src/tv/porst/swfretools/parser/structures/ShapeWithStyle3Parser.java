package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeWithStyle3Parser {

	public static ShapeWithStyle3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle3Array lineStyles = LineStyle3ArrayParser.parse(parser, fieldName + "::LineStyles");
		final Bits numFillBits = parseBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle3(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);

	}

}
