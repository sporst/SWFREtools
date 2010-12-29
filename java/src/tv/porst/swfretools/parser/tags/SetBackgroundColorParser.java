package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RGBParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SetBackgroundColorParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {

		final RGB backgroundColor = RGBParser.parse(parser);

		return new SetBackgroundColorTag(header, backgroundColor);
	}

}
