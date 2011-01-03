package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FrameLabelParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final String name = parser.readString();

		final UINT8 namedAnchorFlag = header.getNormalizedLength() == name.length() + 1 + 1 ? parser.readUInt8() : null;

		return new FrameLabelTag(header, name, namedAnchorFlag);
	}

}
