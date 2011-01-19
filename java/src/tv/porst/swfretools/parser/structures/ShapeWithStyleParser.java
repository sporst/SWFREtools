package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ShapeWithStyleParser {

	public static ShapeWithStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyleArray fillStyles = FillStyleArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyleArray lineStyles = LineStyleArrayParser.parse(parser, fieldName + "::LineStyle");
		final Bits numFillBits = parser.readBits(4);
		final Bits numLineBits = parser.readBits(4);
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);

	}

}
