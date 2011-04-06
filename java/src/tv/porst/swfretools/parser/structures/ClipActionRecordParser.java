package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;

import java.util.List;

import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.actions.as2.ActionRecordParser;

/**
 * Parses ClipActionRecord structures.
 * 
 * @author sp
 */
public final class ClipActionRecordParser {

	/**
	 * Parses a ClipActionRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ClipActionRecord parse(final SWFBinaryParser parser, final int version, final String fieldName) throws SWFParserException {

		final ClipEventFlags eventFlags = ClipEventFlagsParser.parse(parser, version, fieldName);
		final UINT32 actionRecordSize = parseUINT32(parser, 0x00006, fieldName + "::ActionRecordSize");

		// ClipEventKeyPress is null for version <= 5
		final UINT8 keyCode = eventFlags.getClipEventKeyPress() == null ? null : parseUINT8If(parser, 0x00006, eventFlags.getClipEventKeyPress(), fieldName + "::ClipActionsEndFlag");
		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize.value(), fieldName + "::Actions");

		return new ClipActionRecord(eventFlags, actionRecordSize, keyCode, new ActionList(actions));
	}
}