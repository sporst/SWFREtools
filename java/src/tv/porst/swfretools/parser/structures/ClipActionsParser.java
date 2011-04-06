package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ClipActions structures.
 * 
 * @author sp
 */
public final class ClipActionsParser {

	/**
	 * Parses a ClipActions structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ClipActions parse(final SWFBinaryParser parser, final int version, final String fieldName) throws SWFParserException {

		final UINT16 reserved = parseUINT16(parser, 0x00006, fieldName + "::Reserved");
		final ClipEventFlags allEventFlags = ClipEventFlagsParser.parse(parser, version, fieldName);

		final List<ClipActionRecord> clipActionRecords = new ArrayList<ClipActionRecord>();

		do {

			if (version <= 5 && parser.peekUInt16().value() == 0) {
				break;
			}

			if (version > 5 && parser.peekUInt32().value() == 0) {
				break;
			}

			clipActionRecords.add(ClipActionRecordParser.parse(parser, version, fieldName));

		} while (true);

		final IParsedINTElement clipActionEndFlag = version <= 5 ? parseUINT16(parser, 0x00006, fieldName + "::ClipActionsEndFlag") : parseUINT32(parser, 0x00006, fieldName + "::ClipActionsEndFlag");

		return new ClipActions(reserved, allEventFlags, new ClipActionRecordList(clipActionRecords), clipActionEndFlag);
	}

	/**
	 * Parses a ClipActions structure if a condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param condition The condition to be true for the structure to be parsed.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ClipActions parseIf(final SWFBinaryParser parser, final int version, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, version, fieldName) : null;
	}
}