package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses TextRecord structures.
 * 
 * @author sp
 *
 */
public final class TextRecordParser {

	/**
	 * Parses a TextRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param glyphBits
	 * @param advanceBits
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static TextRecord parse(final SWFBinaryParser parser, final int glyphBits, final int advanceBits, final String fieldName) throws SWFParserException {

		final Flag textRecordType = parseFlag(parser, 0x00006, fieldName + "::TextRecordType");
		final UBits styleFlagsReserved = parser.readBits(3);
		final Flag styleFlagsHasFont = parseFlag(parser, 0x00006, fieldName + "::StyleFlagsHasFont");
		final Flag styleFlagsHasColor = parseFlag(parser, 0x00006, fieldName + "::StyleFlagsHasColor");
		final Flag styleFlagsHasYOffset = parseFlag(parser, 0x00006, fieldName + "::StyleFlagsHasYOffset");
		final Flag styleFlagsHasXOffset = parseFlag(parser, 0x00006, fieldName + "::StyleFlagsHasXOffset");
		final UINT16 fontID = parseUINT16If(parser, 0x00006, styleFlagsHasFont, fieldName + "::FontID");
		final RGB textColor = RGBParser.parseIf(parser, styleFlagsHasColor, fieldName + "::TextColor");
		final INT16 xOffset = parseINT16If(parser, 0x00006, styleFlagsHasXOffset, fieldName + "::XOffset");
		final INT16 yOffset = parseINT16If(parser, 0x00006, styleFlagsHasYOffset, fieldName + "::YOffset");
		final UINT16 textHeight = parseUINT16If(parser, 0x00006, styleFlagsHasFont, fieldName + "::TextHeight");
		final UINT8 glyphCount = parseUINT8(parser, 0x00006, fieldName + "::GlyphCount");

		final List<GlyphEntry> glyphEntries = new ArrayList<GlyphEntry>();

		for (int i=0;i<glyphCount.value();i++) {
			glyphEntries.add(GlyphEntryParser.parse(parser, glyphBits, advanceBits, String.format("GlyphEntries[%d]", i)));
		}

		parser.align();

		return new TextRecord(textRecordType, styleFlagsReserved, styleFlagsHasFont,
				styleFlagsHasColor, styleFlagsHasYOffset, styleFlagsHasXOffset,
				fontID, textColor, xOffset, yOffset, textHeight, glyphCount, glyphEntries);
	}
}