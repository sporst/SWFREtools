package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class EndParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		return new EndTag(header);
	}

}
