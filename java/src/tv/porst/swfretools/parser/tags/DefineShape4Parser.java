package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4Parser;

public class DefineShape4Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 shapeId = parser.readUInt16();
		final Rect shapeBounds = RectParser.parse(parser);
		final Rect edgeBounds = RectParser.parse(parser);
		final int reserved = parser.readBits(5);
		final boolean usesFillWindingRule = parser.readFlag();
		final boolean usesNonScalingStrokes = parser.readFlag();
		final boolean usesScalingStrokes = parser.readFlag();
		final ShapeWithStyle4 shapes = ShapeWithStyle4Parser.parse(parser);

		return new DefineShape4Tag(header, shapeId, shapeBounds, shapes);
	}

}
