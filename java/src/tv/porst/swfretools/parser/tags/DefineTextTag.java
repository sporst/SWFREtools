package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.TextRecord;

public class DefineTextTag extends Tag {

	public DefineTextTag(final RecordHeader header, final UINT16 characterID, final Rect textBounds,
			final Matrix textMatrix, final UINT8 glyphBits, final UINT8 advanceBits,
			final List<TextRecord> textRecords) {
		super(header);
	}

}
