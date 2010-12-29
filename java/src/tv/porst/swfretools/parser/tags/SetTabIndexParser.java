package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SetTabIndexParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int depth = parser.readUInt16();
		final int tabIndex = parser.readUInt16();

		return new SetTabIndexTag(header, depth, tabIndex);
	}

}
