package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlagIf;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ClipEventFlags structures.
 * 
 * @author sp
 */
public final class ClipEventFlagsParser {

	/**
	 * Parses a ClipEventFlags structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param version Flash version number which was read from the SWF file header.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ClipEventFlags parse(final SWFBinaryParser parser, final int version, final String fieldName) throws SWFParserException {

		final Flag clipEventKeyUp = parseFlag(parser, 0x00006, fieldName + "::ClipEventKeyUp");
		final Flag clipEventKeyDown = parseFlag(parser, 0x00006, fieldName + "::ClipEventKeyDown");
		final Flag clipEventMouseUp = parseFlag(parser, 0x00006, fieldName + "::ClipEventMouseUp");
		final Flag clipEventMouseDown = parseFlag(parser, 0x00006, fieldName + "::ClipEventMouseDown");
		final Flag clipEventMouseMove = parseFlag(parser, 0x00006, fieldName + "::ClipEventMouseDown");
		final Flag clipEventUnload = parseFlag(parser, 0x00006, fieldName + "::ClipEventUnload");
		final Flag clipEventEnterFrame = parseFlag(parser, 0x00006, fieldName + "::ClipEventEnterFrame");
		final Flag clipEventLoad = parseFlag(parser, 0x00006, fieldName + "::ClipEventLoad");
		final Flag clipEventDragOver = parseFlag(parser, 0x00006, fieldName + "::ClipEventDragOver");
		final Flag clipEventRollOut = parseFlag(parser, 0x00006, fieldName + "::ClipEventRollOut");
		final Flag clipEventRollOver = parseFlag(parser, 0x00006, fieldName + "::ClipEventRollOver");
		final Flag clipEventReleaseOutside = parseFlag(parser, 0x00006, fieldName + "::ClipEventReleaseOutside");
		final Flag clipEventRelease = parseFlag(parser, 0x00006, fieldName + "::ClipEventRelease");
		final Flag clipEventPress = parseFlag(parser, 0x00006, fieldName + "::ClipEventPress");
		final Flag clipEventInitialize = parseFlag(parser, 0x00006, fieldName + "::ClipEventInitialize");
		final Flag clipEventData = parseFlag(parser, 0x00006, fieldName + "::ClipEventData");

		final UBits reserved = parseUBitsIf(parser, 5, 0x00006, version >= 6, fieldName + "::Reserved");
		final Flag clipEventConstruct = parseFlagIf(parser, 0x00006, version >= 6, fieldName + "::ClipEventConstruct");
		final Flag clipEventKeyPress = parseFlagIf(parser, 0x00006, version >= 6, fieldName + "::ClipEventKeyPress");
		final Flag clipEventDragOut = parseFlagIf(parser, 0x00006, version >= 6, fieldName + "::ClipEventDragOut");
		final UBits reserved2 = parseUBitsIf(parser, 8, 0x00006, version >= 6, fieldName + "::Reserved2");

		return new ClipEventFlags(clipEventKeyUp, clipEventKeyDown,
				clipEventMouseUp, clipEventMouseDown, clipEventMouseMove,
				clipEventUnload, clipEventEnterFrame, clipEventLoad,
				clipEventDragOver, clipEventRollOut, clipEventRollOver,
				clipEventReleaseOutside, clipEventRelease, clipEventPress,
				clipEventInitialize, clipEventData, reserved,
				clipEventConstruct, clipEventKeyPress, clipEventDragOut,
				reserved2);
	}
}