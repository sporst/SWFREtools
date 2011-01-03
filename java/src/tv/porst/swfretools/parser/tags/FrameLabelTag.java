package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FrameLabelTag extends Tag {

	public FrameLabelTag(final RecordHeader header, final PString name, final UINT8 namedAnchorFlag) {
		super(header);
	}

}
