package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFloat16;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ZoneData structures.
 * 
 * @author sp
 *
 */
public final class ZoneDataParser {

	/**
	 * Parses a zone data structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return  The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ZoneData parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Float16 alignmentCoordinate = parseFloat16(parser, 0x00006, fieldName + "::AlignmentCoordinate");
		final Float16 range = parseFloat16(parser, 0x00006, fieldName + "::Range");

		return new ZoneData(alignmentCoordinate, range);
	}
}