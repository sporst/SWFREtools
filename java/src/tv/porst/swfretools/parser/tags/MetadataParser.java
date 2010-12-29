package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class MetadataParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final String metadata = parser.readString();

		return new MetadataTag(header, metadata);
	}

}
