package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSpriteParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser, final int version) {
		final int spriteID = parser.readUInt16();
		final int frameCount = parser.readUInt16();

		final int length = header.getNormalizedLength() - 2 - 2;

		final List<Tag> controlTags = TagParser.parse(parser, version, length);

		return new DefineSpriteTag(header, spriteID, frameCount, controlTags);
	}

}
