package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SetTabIndexTag extends Tag {

	public SetTabIndexTag(final RecordHeader header, final UINT16 depth, final UINT16 tabIndex) {
		super(header);
	}

}
