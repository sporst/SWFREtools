package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class RemoveObject2Tag extends Tag {

	public RemoveObject2Tag(final RecordHeader header, final UINT16 depth) {
		super(header);
	}

}
