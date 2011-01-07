package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4Parser;

public class DefineShape4Parser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 shapeId = parser.readUInt16();
		final Rect shapeBounds = RectParser.parse(parser);
		final Rect edgeBounds = RectParser.parse(parser);
		final int reserved = parser.readBits(5);
		final Flag usesFillWindingRule = parser.readFlag();
		final Flag usesNonScalingStrokes = parser.readFlag();
		final Flag usesScalingStrokes = parser.readFlag();
		final ShapeWithStyle4 shapes = ShapeWithStyle4Parser.parse(parser, "Shapes");

		return new DefineShape4Tag(header, shapeId, shapeBounds, edgeBounds, reserved, usesFillWindingRule, usesNonScalingStrokes, usesScalingStrokes, shapes);
	}

}
