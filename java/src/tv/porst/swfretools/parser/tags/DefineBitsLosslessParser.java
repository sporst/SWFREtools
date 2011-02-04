package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.BitmapData15Parser;
import tv.porst.swfretools.parser.structures.BitmapData24;
import tv.porst.swfretools.parser.structures.BitmapData24Parser;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.ColormapDataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineBitsLossless tags.
 * 
 * @author sp
 */
public final class DefineBitsLosslessParser {

	/**
	 * Calculates the size of the image data without the color table.
	 * 
	 * @param header Tag header.
	 * @param bitmapColorTableSize Size of the color table.
	 * 
	 * @return The length of the image data in bytes.
	 */
	private static int getImageSize(final RecordHeader header, final UINT8 bitmapColorTableSize) {

		if (bitmapColorTableSize == null) {
			return 0;
		}
		else {
			final int size = header.getNormalizedLength() - (8 + 3 * (bitmapColorTableSize.value() + 1));

			return size < 0 ? 0 : size;
		}
	}

	/**
	 * Parses a DefineBitsLossless tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineBitsLossless::CharacterId");
		final UINT8 bitmapFormat = parseUINT8(parser, 0x00006, "DefineBitsLossless::BitmapFormat");
		final UINT16 bitmapWidth = parseUINT16(parser, 0x00006, "DefineBitsLossless::BitmapWidth");
		final UINT16 bitmapHeight = parseUINT16(parser, 0x00006, "DefineBitsLossless::BitmapHeight");

		final int bitmapFormatValue = bitmapFormat.value();

		final UINT8 bitmapColorTableSize = parseUINT8If(parser, 0x00006, bitmapFormatValue == 3, "DefineBitsLossless::BitmapColorTableSize");
		final ColormapData zlibColormapData = ColormapDataParser.parseIf(parser, bitmapFormatValue == 3, bitmapColorTableSize == null ? 0 : bitmapColorTableSize.value(), getImageSize(header, bitmapColorTableSize), "DefineBitsLossless::ZlibColormapData");
		final BitmapData15 zlibBitmapData15 = BitmapData15Parser.parseIf(parser, bitmapFormatValue == 4, header.getNormalizedLength(), "DefineBitsLossless::ZlibBitmapData15");
		final BitmapData24 zlibBitmapData24 = BitmapData24Parser.parseIf(parser, bitmapFormatValue == 5, header.getNormalizedLength(), "DefineBitsLossless::ZlibBitmapData24");

		return new DefineBitsLosslessTag(header, characterId, bitmapFormat, bitmapWidth, bitmapHeight, bitmapColorTableSize, zlibColormapData, zlibBitmapData15, zlibBitmapData24);
	}
}