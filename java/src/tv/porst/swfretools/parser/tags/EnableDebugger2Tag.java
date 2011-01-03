package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class EnableDebugger2Tag extends Tag {

	public EnableDebugger2Tag(final RecordHeader header, final UINT16 reserved, final String password) {
		super(header);
	}

}
