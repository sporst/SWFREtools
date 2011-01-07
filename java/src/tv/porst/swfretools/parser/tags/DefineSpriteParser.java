package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSpriteParser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser, final int version) {
		final UINT16 spriteID = parser.readUInt16();
		final UINT16 frameCount = parser.readUInt16();

		final int length = header.getNormalizedLength() - 2 - 2;

		final TagParserResult parserResult = TagParser.parse(parser, version, length);

		return new DefineSpriteTag(header, spriteID, frameCount, parserResult.getTags());
	}

}
