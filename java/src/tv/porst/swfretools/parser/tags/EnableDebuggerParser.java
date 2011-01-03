package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class EnableDebuggerParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final PString password = parser.readString();

		return new EnableDebuggerTag(header, password);
	}

}
