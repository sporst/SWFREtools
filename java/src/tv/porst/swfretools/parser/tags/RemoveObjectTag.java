package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class RemoveObjectTag extends Tag {

	public RemoveObjectTag(final RecordHeader header, final UINT16 characterId, final UINT16 depth) {

		super(header);
	}

}
