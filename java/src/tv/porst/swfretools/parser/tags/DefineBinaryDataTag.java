package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBinaryDataTag extends Tag {

	public DefineBinaryDataTag(final RecordHeader header, final int tag, final long reserved,
			final byte[] data) {
		super(header);
	}

}
