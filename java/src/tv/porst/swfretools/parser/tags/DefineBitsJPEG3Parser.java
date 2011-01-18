package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineBitsJPEG3 tags.
 * 
 * @author sp
 */
public final class DefineBitsJPEG3Parser {

	/**
	 * Parses a DefineBitsJPEG3 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineBitsJPEG3Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineBitsJPEG3::CharacterId");
		final UINT32 alphaDataOffset = parseUINT32(parser, 0x00006, "DefineBitsJPEG3::AlphaDataOffset");
		final ByteArray imageData = parseByteArray(parser, alphaDataOffset.value(), 0x00006, "DefineBitsJPEG3::ImageData");
		final ByteArray bitmapAlphaData = parseByteArray(parser, header.getNormalizedLength() - alphaDataOffset.value(), 0x00006, "DefineBitsJPEG3::BitmapAlphaData");

		return new DefineBitsJPEG3Tag(header, characterId, alphaDataOffset, imageData, bitmapAlphaData);
	}
}