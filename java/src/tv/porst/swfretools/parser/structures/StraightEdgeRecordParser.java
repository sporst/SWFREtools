package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlagIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses StraightEdgeRecord structures.
 * 
 * @author sp
 *
 */
public final class StraightEdgeRecordParser {

	/**
	 * Parses a StraightEdgeRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static StraightEdgeRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parseFlag(parser, 0x00006, fieldName + "::TypeFlag");
		final Flag straightFlag = parseFlag(parser, 0x00006, fieldName + "::StraightFlag");
		final UBits numBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumBits");
		final Flag generalLineFlag = parseFlag(parser, 0x00006, fieldName + "::GeneralLineFlag");
		final Flag vertLineFlag =  parseFlagIf(parser, 0x00006, !generalLineFlag.value(), fieldName + "::VertLineFlag");
		final Bits deltaX = parseSBitsIf(parser, numBits.value() + 2, 0x00006, generalLineFlag.value() || !vertLineFlag.value(), fieldName + "::DeltaX");
		final Bits deltaY = parseSBitsIf(parser, numBits.value() + 2, 0x00006, generalLineFlag.value() || vertLineFlag.value(), fieldName + "::DeltaY");

		return new StraightEdgeRecord(typeFlag, straightFlag, numBits, generalLineFlag, vertLineFlag, deltaX, deltaY);
	}
}