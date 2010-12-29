package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ProtectParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		return new ProtectTag(header);
	}

}
