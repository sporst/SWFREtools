package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ShowFrameParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		return new ShowFrameTag(header);
	}

}
