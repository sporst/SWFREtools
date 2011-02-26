package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.AS2Data;
import tv.porst.swfretools.parser.structures.AS2DataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DoABC tags.
 * 
 * @author sp
 */
public final class DoABCParser {

	/**
	 * Parses a DoABC tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DoABCTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT32 flags = parseUINT32(parser, 0x00006, "DoABC::Flags");
		final AsciiString name = parseString(parser, 0x00006, "DoABC::Name");

		final AS2Data abcData = AS2DataParser.parse(parser, "DoABC::ABCData");

		return new DoABCTag(header, flags, name);
	}

}
