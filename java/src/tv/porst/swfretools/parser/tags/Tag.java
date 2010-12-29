package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public abstract class Tag {

	private final RecordHeader header;

	public Tag(final RecordHeader header) {
		this.header = header;
	}

}
