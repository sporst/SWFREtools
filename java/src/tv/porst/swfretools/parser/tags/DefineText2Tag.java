package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.TextRecord2;

public class DefineText2Tag extends Tag {

	public DefineText2Tag(final RecordHeader header, final int characterID,
			final Rect textBounds, final Matrix textMatrix, final int glyphBits, final int advanceBits,
			final List<TextRecord2> textRecords) {
		super(header);
	}

}
