package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class RemoveObjectParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {

		final int characterId = parser.readUInt16();
		final int depth = parser.readUInt16();

		return new RemoveObjectTag(header, characterId, depth);
	}

}
