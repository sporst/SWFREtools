package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeWithStyle4Parser {

	public static ShapeWithStyle4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle4Array lineStyles = LineStyle4ArrayParser.parse(parser, fieldName + "::LineStyles");
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle4(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);
	}

}
