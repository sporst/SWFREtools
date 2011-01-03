package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.TextRecord;

public class DefineTextTag extends Tag {

	public DefineTextTag(final RecordHeader header, final int characterID, final Rect textBounds,
			final Matrix textMatrix, final int glyphBits, final int advanceBits,
			final List<TextRecord> textRecords) {
		super(header);
	}

}
