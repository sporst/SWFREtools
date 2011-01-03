package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.IParsedUINTElement;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape;

public class DefineFont2Tag extends Tag {

	public DefineFont2Tag(final RecordHeader header, final UINT16 fontId,
			final boolean fontFlagsHasLayout, final boolean fontFlagsShiftJIS,
			final boolean fontFlagsSmallText, final boolean fontFlagsANSI,
			final boolean fontFlagsWideOffsets, final boolean fontFlagsWideCodes,
			final boolean fontFlagsItalic, final boolean fontFlagsBold, final UINT8 languageCode,
			final UINT8 fontNameLen, final String fontName, final UINT16 numGlyphs,
			final List<IParsedUINTElement> offsetTable, final IParsedUINTElement codeTableOffset,
			final List<Shape> glyphShapeTable, final List<IParsedUINTElement> codeTable,
			final int fontAscent, final int fontDescent, final int fontLeading,
			final List<Integer> fontAdvanceTable, final List<Rect> fontBoundsTable,
			final int kerningCount, final List<KerningRecord> fontKerningTable) {
		super(header);
	}

}
