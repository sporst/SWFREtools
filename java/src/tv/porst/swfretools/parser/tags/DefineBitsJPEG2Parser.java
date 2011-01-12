package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineBitsJPEG2 tags.
 * 
 * @author sp
 */
public final class DefineBitsJPEG2Parser {

	/**
	 * Parses a DefineBitsJPEG2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineBitsJPEG2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineBitsJPEG2::CharacterId");
		final ByteArray imageData = parseByteArray(parser, header.getNormalizedLength(), 0x00006, "DefineBitsJPEG2::ImageData");

		return new DefineBitsJPEG2Tag(header, characterId, imageData);
	}

}
