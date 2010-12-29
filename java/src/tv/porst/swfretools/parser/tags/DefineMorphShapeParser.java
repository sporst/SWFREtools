package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphFillStyleArrayParser;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArrayParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

public class DefineMorphShapeParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterId = parser.readUInt16();
		final Rect startBounds = RectParser.parse(parser);
		final Rect endBounds = RectParser.parse(parser);
		final long offset = parser.readUInt32();
		final MorphFillStyleArray morphFillStyles = MorphFillStyleArrayParser.parse(parser);
		final MorphLineStyleArray morphLineStyles = MorphLineStyleArrayParser.parse(parser);

		return new DefineMorphShapeTag(header, characterId, startBounds, endBounds, offset, morphFillStyles, morphLineStyles);
	}

}
