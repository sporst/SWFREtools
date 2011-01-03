package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;

public class DefineShape3Tag extends Tag {

	public DefineShape3Tag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds,
			final ShapeWithStyle3 shapes) {
		super(header);
	}

}
