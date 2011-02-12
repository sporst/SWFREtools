package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

/**
 * Class for parsing DefineFont2 tags.
 * 
 * @author sp
 */
public final class DefineFont2Parser {

	/**
	 * Parses a DefineFont2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFont2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineFont2::FontId");
		final Flag fontFlagsHasLayout = parser.readFlag();
		final Flag fontFlagsShiftJIS = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsShiftJIS");
		final Flag fontFlagsSmallText = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsSmallText");
		final Flag fontFlagsANSI = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsANSI");
		final Flag fontFlagsWideOffsets = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsWideOffsets");
		final Flag fontFlagsWideCodes = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsWideCodes");
		final Flag fontFlagsItalic = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsItalic");
		final Flag fontFlagsBold = parseFlag(parser, 0x00006, "DefineFont2::FontFlagsBold");
		final UINT8 languageCode = parseUINT8(parser, 0x00006, "Define2::LanguageCode");
		final UINT8 fontNameLen = parseUINT8(parser, 0x00006, "DefineFont2::FontNameLen");
		final AsciiString fontName = parseString(parser, fontNameLen.value(), 0x00006, "DefineFont2::FontName");
		final UINT16 numGlyphs = parseUINT16(parser, 0x00006, "DefineFont2::NumGlyphs");

		final List<IParsedINTElement> offsetTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numGlyphs.value();i++) {
			if (fontFlagsWideOffsets.value()) {
				offsetTable.add(parseUINT32(parser, 0x00006, String.format("DefineFont2::OffsetTable[%d]", i)));
			}
			else {
				offsetTable.add(parseUINT16(parser, 0x00006, String.format("DefineFont2::OffsetTable[%d]", i)));
			}
		}

		final IParsedINTElement codeTableOffset = fontFlagsWideOffsets.value() ? parseUINT32(parser, 0x00006, "DefineFont2::CodeTableOffset") : parseUINT16(parser, 0x00006, "DefineFont2::CodeTableOffset");

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numGlyphs.value();i++) {
			System.out.println(i + " " + parser.getLength());
			glyphShapeTable.add(ShapeParser.parse(parser, String.format("GlyphShapeTable[%d]", i)));
		}

		final List<IParsedINTElement> codeTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numGlyphs.value();i++) {
			if (fontFlagsWideCodes.value()) {
				offsetTable.add(parseUINT16(parser, 0x00006, String.format("DefineFont2::CodeTable[%d]", i)));
			}
			else {
				offsetTable.add(parseUINT8(parser, 0x00006, String.format("DefineFont2::CodeTable[%d]", i)));
			}
		}

		final INT16 fontAscent = parseINT16If(parser, 0x00006, fontFlagsHasLayout, "DefineFont2::FontAscent");
		final INT16 fontDescent = parseINT16If(parser, 0x00006, fontFlagsHasLayout, "DefineFont2::FontDescent");
		final INT16 fontLeading = parseINT16If(parser, 0x00006, fontFlagsHasLayout, "DefineFont2::FontLeading");

		final List<INT16> fontAdvanceTable = new ArrayList<INT16>();
		final List<Rect> fontBoundsTable = new ArrayList<Rect>();

		if (fontFlagsHasLayout.value()) {
			for (int i=0;i<numGlyphs.value();i++) {
				fontAdvanceTable.add(parseINT16(parser, 0x00006, String.format("DefineFont2::FontAdvanceTable[%d]", i)));
			}

			for (int i=0;i<numGlyphs.value();i++) {
				System.out.printf("XXX: %d - %X\n", i, parser.getBytePosition());
				fontBoundsTable.add(RectParser.parse(parser, String.format("DefineFont2::FontBoundsTable[%d]", i)));
			}
		}

		final UINT16 kerningCount = parseUINT16If(parser, 0x00006, fontFlagsHasLayout, "DefineFont2::KerningCount");

		final List<KerningRecord> fontKerningTable = new ArrayList<KerningRecord>();

		if (fontFlagsHasLayout.value()) {
			for (int i=0;i<kerningCount.value();i++) {
				fontKerningTable.add(KerningRecordParser.parse(parser, fontFlagsWideCodes.value(), String.format("DefineFont2::FontKerningTable[%d]", i)));
			}
		}

		return new DefineFont2Tag(header, fontId, fontFlagsHasLayout, fontFlagsShiftJIS,
				fontFlagsSmallText, fontFlagsANSI, fontFlagsWideOffsets, fontFlagsWideCodes,
				fontFlagsItalic, fontFlagsBold, languageCode, fontNameLen, fontName,
				numGlyphs, offsetTable, codeTableOffset, glyphShapeTable, codeTable, fontAscent,
				fontDescent, fontLeading, fontAdvanceTable, fontBoundsTable, kerningCount,
				fontKerningTable);
	}
}