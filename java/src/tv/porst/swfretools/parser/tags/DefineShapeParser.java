package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;
import tv.porst.swfretools.parser.structures.ShapeWithStyleParser;

public class DefineShapeParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int shapeId = parser.readUInt16();
		final Rect shapeBounds = RectParser.parse(parser);
		final ShapeWithStyle shapes = ShapeWithStyleParser.parse(parser);

		return new DefineShapeTag(header, shapeId, shapeBounds, shapes);
	}

}
