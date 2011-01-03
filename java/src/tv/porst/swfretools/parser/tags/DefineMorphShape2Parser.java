package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphFillStyleArrayParser;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2Parser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

public class DefineMorphShape2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterId = parser.readUInt16();
		final Rect startBounds = RectParser.parse(parser);
		final Rect endBounds = RectParser.parse(parser);
		final Rect startEdgeBounds = RectParser.parse(parser);
		final Rect endEdgeBounds = RectParser.parse(parser);
		final int reserved = parser.readBits(6);
		final boolean useNonScalingStrokes = parser.readFlag();
		final boolean useScalingStrokes = parser.readFlag();
		final UINT32 offset = parser.readUInt32();
		final MorphFillStyleArray morphFillStyles = MorphFillStyleArrayParser.parse(parser);
		final MorphLineStyleArray2 morphLineStyles = MorphLineStyleArray2Parser.parse(parser);

		return new DefineMorphShape2Tag(header, characterId, startBounds, endBounds, startEdgeBounds, endEdgeBounds, reserved, useNonScalingStrokes, useScalingStrokes, offset, morphFillStyles, morphLineStyles);
	}

}
