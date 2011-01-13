package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineButtonCxform tags.
 * 
 * @author sp
 */
public final class DefineButtonCxformParser {

	/**
	 * Parses a DefineButtonCxform tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 buttonId = parseUINT16(parser, 0x00006, "DefineButtonCxform::ButtonId");
		final CxForm buttonColorTransform = CxFormParser.parse(parser, "DefineButtonCxform::ButtonColorTransform");

		return new DefineButtonCxformTag(header, buttonId, buttonColorTransform);
	}
}