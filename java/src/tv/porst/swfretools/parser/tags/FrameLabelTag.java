package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FrameLabelTag extends Tag {

	public FrameLabelTag(final RecordHeader header, final String name, final UINT8 namedAnchorFlag) {
		super(header);
	}

}
