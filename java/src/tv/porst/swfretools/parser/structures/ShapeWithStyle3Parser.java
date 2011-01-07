package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeWithStyle3Parser {

	public static ShapeWithStyle3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle3Array lineStyles = LineStyle3ArrayParser.parse(parser);
		final int numFillBits = parser.readBits(4);
		final int numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle3(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);

	}

}
