package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSpriteTag extends Tag {

	public DefineSpriteTag(final RecordHeader header, final UINT16 spriteID, final UINT16 frameCount,
			final List<Tag> controlTags) {
		super(header);
	}

}
