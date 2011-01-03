package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;

public class DefineScalingGridParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterId = parser.readUInt16();
		final Rect splitter = RectParser.parse(parser);

		return new DefineScalingGridTag(header, characterId, splitter);
	}

}
