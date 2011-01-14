package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;

public class DefineShape4Tag extends Tag {

	public DefineShape4Tag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds,
			final Rect edgeBounds, final Bits reserved, final Flag usesFillWindingRule, final Flag usesNonScalingStrokes, final Flag usesScalingStrokes, final ShapeWithStyle4 shapes) {
		super(header);
	}

}
