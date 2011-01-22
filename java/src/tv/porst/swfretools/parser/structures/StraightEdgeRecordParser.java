package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlagIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;
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
		final Bits numBits = parseBits(parser, 4, 0x00006, fieldName + "::NumBits");
		final Flag generalLineFlag = parseFlag(parser, 0x00006, fieldName + "::GeneralLineFlag");
		final Flag vertLineFlag =  parseFlagIf(parser, 0x00006, !generalLineFlag.value(), fieldName + "::VertLineFlag");
		final SBits deltaX = parseSBitsIf(parser, 0x00006, numBits.value() + 2, generalLineFlag.value() || !vertLineFlag.value(), fieldName + "::DeltaX");
		final SBits deltaY = parseSBitsIf(parser, 0x00006, numBits.value() + 2, generalLineFlag.value() || vertLineFlag.value(), fieldName + "::DeltaY");

		return new StraightEdgeRecord(typeFlag, straightFlag, numBits, generalLineFlag, vertLineFlag, deltaX, deltaY);
	}
}