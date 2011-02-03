package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeWithStyle3 structures.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle3Parser {

	/**
	 * Parses a ShapeWithStyle3 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeWithStyle3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyle3Array lineStyles = LineStyle3ArrayParser.parse(parser, fieldName + "::LineStyles");
		final UBits numFillBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final UBits numLineBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final List<ShapeRecord> shapeRecords = new ArrayList<ShapeRecord>();

		ShapeRecord shapeRecord = null;

		UBits currentNumFillBits = numFillBits;
		UBits currentNumLineBits = numLineBits;

		do {

			shapeRecord = ShapeRecordParser.parse(parser, currentNumFillBits, currentNumLineBits, fieldName + "::ShapeRecord");

			shapeRecords.add(shapeRecord);

			if (shapeRecord instanceof StyleChangeRecord) {
				currentNumFillBits = ((StyleChangeRecord) shapeRecord).getNumFillBits();
				currentNumLineBits = ((StyleChangeRecord) shapeRecord).getNumLineBits();
			}

		} while (!(shapeRecord instanceof EndShapeRecord));

		parser.align();

		return new ShapeWithStyle3(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);
	}
}