package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing ScriptLimitsParser tags.
 * 
 * @author sp
 */
public final class ScriptLimitsParser {

	/**
	 * Parses a ScriptLimits tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static ScriptLimitsTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 maxRecursionDepth = parseUINT16(parser, 0x00006, "ScriptLimitsParser::MaxRecursionDepth");
		final UINT16 scriptTimeoutSeconds = parseUINT16(parser, 0x00006, "ScriptLimitsParser::ScriptTimeoutSeconds");

		return new ScriptLimitsTag(header, maxRecursionDepth, scriptTimeoutSeconds);
	}
}