package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing Protect tags.
 */
public final class ProtectParser {

	/**
	 * Parses a Protect tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static ProtectTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final ByteArray data = SWFParserHelpers.parseByteArrayIf(parser, header.getNormalizedLength(), 0x00005, header.getNormalizedLength() != 0, "Data");

		return new ProtectTag(header, data);
	}
}