package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ShapeRecord structures.
 * 
 * @author sp
 *
 */
public final class ShapeRecordParser {

	/**
	 * Parses a ShapeRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fillBits Number of bits for fill style values.
	 * @param lineBits Number of bits for line style values.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ShapeRecord parse(final SWFBinaryParser parser, final UBits fillBits, final UBits lineBits, final String fieldName) throws SWFParserException {

		final UBits first6 = parser.peekBits(6);

		if (first6.value() == 0) {
			return EndShapeRecordParser.parse(parser, fieldName);
		}
		else if ((first6.value() & 0x20) == 0x20) {
			return StyleChangeRecordParser.parse(parser, fillBits, lineBits, fieldName);
		}
		else if ((first6.value() & 0x10) == 0x10) {
			return StraightEdgeRecordParser.parse(parser, fieldName);
		}
		else {
			return CurvedEdgeRecordParser.parse(parser, fieldName);
		}
	}
}