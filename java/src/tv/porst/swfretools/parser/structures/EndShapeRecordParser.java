package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses EndShapeRecord structures.
 * 
 * @author sp
 */
public final class EndShapeRecordParser {

	/**
	 * Parses an EndShapeRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static EndShapeRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parseFlag(parser, 0x00006, fieldName + "::NumberOfFilters");
		final UBits endOfShape = parseUBits(parser, 5, 0x00006, fieldName + "::EndOfShape");

		return new EndShapeRecord(typeFlag, endOfShape);
	}
}