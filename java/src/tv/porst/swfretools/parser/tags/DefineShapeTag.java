package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;

public class DefineShapeTag extends Tag {

	public DefineShapeTag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds, final ShapeWithStyle shapes) {
		super(header);
	}

}
