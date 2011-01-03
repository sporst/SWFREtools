package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3Parser;

public class DefineShape3Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 shapeId = parser.readUInt16();
		final Rect shapeBounds = RectParser.parse(parser);
		final ShapeWithStyle3 shapes = ShapeWithStyle3Parser.parse(parser);

		return new DefineShape3Tag(header, shapeId, shapeBounds, shapes);
	}

}
