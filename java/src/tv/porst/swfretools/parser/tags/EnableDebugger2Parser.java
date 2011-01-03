package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class EnableDebugger2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 reserved = parser.readUInt16();
		final String password = parser.readString();

		return new EnableDebugger2Tag(header, reserved, password);
	}

}
