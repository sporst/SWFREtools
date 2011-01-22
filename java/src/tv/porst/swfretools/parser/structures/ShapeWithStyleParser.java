package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeWithStyle structures.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyleParser {

	/**
	 * Parses a ShapeWithStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeWithStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final FillStyleArray fillStyles = FillStyleArrayParser.parse(parser, fieldName + "::FillStyles");
		final LineStyleArray lineStyles = LineStyleArrayParser.parse(parser, fieldName + "::LineStyle");
		final Bits numFillBits = parseBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final ShapeRecord shapeRecord = ShapeRecordParser.parse(parser, numFillBits, numLineBits, fieldName + "::ShapeRecord");

		return new ShapeWithStyle(fillStyles, lineStyles, numFillBits, numLineBits, shapeRecord);

	}
}