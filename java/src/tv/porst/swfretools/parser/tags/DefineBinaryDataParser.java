package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;


/**
 * Class for parsing DefineBinaryData tags.
 */
public final class DefineBinaryDataParser {

	/**
	 * Parses a DefineBinaryData tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineBinaryDataTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 tag = parseUINT16(parser, 0x00006, "DefineBinaryData::Tag");
		final UINT32 reserved = parseUINT32(parser, 0x00006, "DefineBinaryData::Reserved");
		final ByteArray data = parseByteArray(parser, header.getNormalizedLength() - 2 - 4, 0x00006, "DefineBinaryData::Data");

		return new DefineBinaryDataTag(header, tag, reserved, data);
	}
}