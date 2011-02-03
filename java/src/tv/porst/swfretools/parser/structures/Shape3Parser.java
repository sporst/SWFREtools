package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses Shape3 structure.
 * 
 * @author sp
 *
 */
public final class Shape3Parser {

	/**
	 * Parses a Shape3Record structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Shape3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UBits numFillBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumFillBits");
		final UBits numLineBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumLineBits");
		final List<Shape3Record> shapeRecords = new ArrayList<Shape3Record>();

		Shape3Record shapeRecord = null;

		UBits currentNumFillBits = numFillBits;
		UBits currentNumLineBits = numLineBits;

		do {

			shapeRecord = ShapeRecord3Parser.parse(parser, currentNumFillBits, currentNumLineBits, fieldName + "::ShapeRecord");

			shapeRecords.add(shapeRecord);

			if (shapeRecord instanceof StyleChangeRecord3) {
				currentNumFillBits = ((StyleChangeRecord3) shapeRecord).getNumFillBits();
				currentNumLineBits = ((StyleChangeRecord3) shapeRecord).getNumLineBits();
			}

		} while (!(shapeRecord instanceof EndShapeRecord));

		parser.align();

		return new Shape3(numFillBits, numLineBits, shapeRecord);
	}
}