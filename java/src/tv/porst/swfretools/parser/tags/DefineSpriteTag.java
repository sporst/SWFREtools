package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSpriteTag extends Tag {

	public DefineSpriteTag(final RecordHeader header, final int spriteID, final int frameCount,
			final List<Tag> controlTags) {
		super(header);
	}

}
