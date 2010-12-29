package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

public class DefineMorphShapeTag extends Tag {

	public DefineMorphShapeTag(final RecordHeader header, final int characterId, final Rect startBounds,
			final Rect endBounds, final long offset, final MorphFillStyleArray morphFillStyles,
			final MorphLineStyleArray morphLineStyles) {
		super(header);
	}

}
