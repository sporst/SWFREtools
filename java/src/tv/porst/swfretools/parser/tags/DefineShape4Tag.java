package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;

public class DefineShape4Tag extends Tag {

	public DefineShape4Tag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds,
			final ShapeWithStyle4 shapes) {
		super(header);
	}

}
