package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.KerningRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

public class DefineFont3Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int fontId = parser.readUInt16();
		final boolean fontFlagsHasLayout = parser.readFlag();
		final boolean fontFlagsShiftJIS = parser.readFlag();
		final boolean fontFlagsSmallText = parser.readFlag();
		final boolean fontFlagsANSI = parser.readFlag();
		final boolean fontFlagsWideOffsets = parser.readFlag();
		final boolean fontFlagsWideCodes = parser.readFlag();
		final boolean fontFlagsItalic = parser.readFlag();
		final boolean fontFlagsBold = parser.readFlag();
		final int languageCode = parser.readUInt8();
		final int fontNameLen = parser.readUInt8();
		final String fontName = parser.readString(fontNameLen);
		final int numGlyphs = parser.readUInt16();

		final List<Long> offsetTable = new ArrayList<Long>();

		for (int i=0;i<numGlyphs;i++) {
			if (fontFlagsWideOffsets) {
				offsetTable.add(parser.readUInt32());
			}
			else {
				offsetTable.add((long) parser.readUInt16());
			}
		}

		final long codeTableOffset = fontFlagsWideOffsets ? parser.readUInt32() : parser.readUInt16();

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numGlyphs;i++) {
			glyphShapeTable.add(ShapeParser.parse(parser));
		}

		final List<Integer> codeTable = new ArrayList<Integer>();

		for (int i=0;i<numGlyphs;i++) {
			codeTable.add(parser.readUInt16());
		}

		final int fontAscent = fontFlagsHasLayout ? parser.readInt16() : 0;
		final int fontDescent = fontFlagsHasLayout ? parser.readInt16() : 0;
		final int fontLeading = fontFlagsHasLayout ? parser.readInt16() : 0;

		final List<Integer> fontAdvanceTable = new ArrayList<Integer>();
		final List<Rect> fontBoundsTable = new ArrayList<Rect>();

		if (fontFlagsHasLayout) {
			for (int i=0;i<numGlyphs;i++) {
				fontAdvanceTable.add(parser.readInt16());
			}

			for (int i=0;i<numGlyphs;i++) {
				fontBoundsTable.add(RectParser.parse(parser));
			}
		}

		final int kerningCount = fontFlagsHasLayout ? parser.readInt16() : 0;

		final List<KerningRecord> fontKerningTable = new ArrayList<KerningRecord>();

		if (fontFlagsHasLayout) {
			for (int i=0;i<kerningCount;i++) {
				fontKerningTable.add(KerningRecordParser.parse(parser, fontFlagsWideCodes));
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
