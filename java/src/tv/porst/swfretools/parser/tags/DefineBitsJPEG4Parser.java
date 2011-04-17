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
 * Class for parsing DefineBitsJPEG4 tags.
 */
public final class DefineBitsJPEG4Parser {

	/**
	 * Parses a DefineBitsJPEG4 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineBitsJPEG4Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineBitsJPEG4::CharacterId");
		final UINT32 alphaDataOffset = parseUINT32(parser, 0x00006, "DefineBitsJPEG4::AlphaDataOffset");
		final UINT16 deblockParam = parseUINT16(parser, 0x00006, "DefineBitsLossless::DeblockParam");
		final ByteArray imageData = parseByteArray(parser, alphaDataOffset.value(), 0x00006, "DefineBitsJPEG4::ImageData");
		final ByteArray bitmapAlphaData = parseByteArray(parser, header.getNormalizedLength() - alphaDataOffset.value(), 0x00006, "DefineBitsJPEG4::BitmapAlphaData");

		return new DefineBitsJPEG4Tag(header, characterId, alphaDataOffset, deblockParam, imageData, bitmapAlphaData);
	}
}