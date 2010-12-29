package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class EnableDebugger2Tag extends Tag {

	public EnableDebugger2Tag(final RecordHeader header, final int reserved, final String password) {
		super(header);
	}

}
