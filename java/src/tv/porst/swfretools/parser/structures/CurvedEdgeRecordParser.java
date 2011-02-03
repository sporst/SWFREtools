package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses CurvedEdgeRecord structures.
 * 
 * @author sp
 */
public final class CurvedEdgeRecordParser {

	/**
	 * Parses a CurvedEdgeRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static CurvedEdgeRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parseFlag(parser, 0x00006, fieldName + "::TypeFlag");
		final Flag straightFlag = parseFlag(parser, 0x00006, fieldName + "::StraightFlag");
		final UBits numBits = parseUBits(parser, 4, 0x00006, fieldName + "::NumBits");
		final Bits controlDeltaX = parseSBits(parser, numBits.value() + 2, 0x00006, fieldName + "::ControlDeltaX");
		final Bits controlDeltaY = parseSBits(parser, numBits.value() + 2, 0x00006, fieldName + "::ControlDeltaY");
		final Bits anchorDeltaX = parseSBits(parser, numBits.value() + 2, 0x00006, fieldName + "::AnchorDeltaX");
		final Bits anchorDeltaY = parseSBits(parser, numBits.value() + 2, 0x00006, fieldName + "::AnchorDeltaY");

		return new CurvedEdgeRecord(typeFlag, straightFlag, numBits, controlDeltaX, controlDeltaY, anchorDeltaX, anchorDeltaY);
	}
}