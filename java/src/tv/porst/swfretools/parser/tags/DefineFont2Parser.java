package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

public class DefineFont2Parser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 fontId = parser.readUInt16();
		final Flag fontFlagsHasLayout = parser.readFlag();
		final Flag fontFlagsShiftJIS = parser.readFlag();
		final Flag fontFlagsSmallText = parser.readFlag();
		final Flag fontFlagsANSI = parser.readFlag();
		final Flag fontFlagsWideOffsets = parser.readFlag();
		final Flag fontFlagsWideCodes = parser.readFlag();
		final Flag fontFlagsItalic = parser.readFlag();
		final Flag fontFlagsBold = parser.readFlag();
		final UINT8 languageCode = parser.readUInt8();
		final UINT8 fontNameLen = parser.readUInt8();
		final PString fontName = parser.readString(fontNameLen.value());
		final UINT16 numGlyphs = parser.readUInt16();

		final List<IParsedINTElement> offsetTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numGlyphs.value();i++) {
			if (fontFlagsWideOffsets.value()) {
				offsetTable.add(parser.readUInt32());
			}
			else {
				offsetTable.add(parser.readUInt16());
			}
		}

		final IParsedINTElement codeTableOffset = fontFlagsWideOffsets.value() ? parser.readUInt32() : parser.readUInt16();

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numGlyphs.value();i++) {
			glyphShapeTable.add(ShapeParser.parse(parser, String.format("GlyphShapeTable[%d]", i)));
		}

		final List<IParsedINTElement> codeTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numGlyphs.value();i++) {
			if (fontFlagsWideCodes.value()) {
				codeTable.add(parser.readUInt16());
			}
			else {
				codeTable.add(parser.readUInt8());
			}
		}

		final INT16 fontAscent = fontFlagsHasLayout.value() ? parser.readInt16() : null;
		final INT16 fontDescent = fontFlagsHasLayout.value() ? parser.readInt16() : null;
		final INT16 fontLeading = fontFlagsHasLayout.value() ? parser.readInt16() : null;

		final List<INT16> fontAdvanceTable = new ArrayList<INT16>();
		final List<Rect> fontBoundsTable = new ArrayList<Rect>();

		if (fontFlagsHasLayout.value()) {
			for (int i=0;i<numGlyphs.value();i++) {
				fontAdvanceTable.add(parser.readInt16());
			}

			for (int i=0;i<numGlyphs.value();i++) {
				fontBoundsTable.add(RectParser.parse(parser, String.format("DefineFont2::FontBoundsTable[%d]", i)));
			}
		}

		final UINT16 kerningCount = fontFlagsHasLayout.value() ? parser.readUInt16() : null;

		final List<KerningRecord> fontKerningTable = new ArrayList<KerningRecord>();

		if (fontFlagsHasLayout.value()) {
			for (int i=0;i<kerningCount.value();i++) {
				fontKerningTable.add(KerningRecordParser.parse(parser, fontFlagsWideCodes.value()));
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
