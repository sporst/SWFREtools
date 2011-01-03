package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.KerningRecord;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape;

public class DefineFont2Tag extends Tag {

	public DefineFont2Tag(final RecordHeader header, final UINT16 fontId,
			final Flag fontFlagsHasLayout, final Flag fontFlagsShiftJIS,
			final Flag fontFlagsSmallText, final Flag fontFlagsANSI,
			final Flag fontFlagsWideOffsets, final Flag fontFlagsWideCodes,
			final Flag fontFlagsItalic, final Flag fontFlagsBold, final UINT8 languageCode,
			final UINT8 fontNameLen, final PString fontName, final UINT16 numGlyphs,
			final List<IParsedINTElement> offsetTable, final IParsedINTElement codeTableOffset,
			final List<Shape> glyphShapeTable, final List<IParsedINTElement> codeTable,
			final INT16 fontAscent, final INT16 fontDescent, final INT16 fontLeading,
			final List<INT16> fontAdvanceTable, final List<Rect> fontBoundsTable,
			final UINT16 kerningCount, final List<KerningRecord> fontKerningTable) {
		super(header);
	}

}
