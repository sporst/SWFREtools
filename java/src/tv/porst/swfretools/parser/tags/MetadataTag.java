package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class MetadataTag extends Tag {

	public MetadataTag(final RecordHeader header, final PString metadata) {
		super(header);
	}

}
