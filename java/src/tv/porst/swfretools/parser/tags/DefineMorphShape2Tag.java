package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

public class DefineMorphShape2Tag extends Tag {

	public DefineMorphShape2Tag(final RecordHeader header, final UINT16 characterId,
			final Rect startBounds, final Rect endBounds, final Rect startEdgeBounds,
			final Rect endEdgeBounds, final int reserved, final Flag useNonScalingStrokes,
			final Flag useScalingStrokes, final UINT32 offset,
			final MorphFillStyleArray morphFillStyles,
			final MorphLineStyleArray2 morphLineStyles) {
		super(header);
	}

}
