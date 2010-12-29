package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SetBackgroundColorTag extends Tag {

	public SetBackgroundColorTag(final RecordHeader header, final RGB backgroundColor) {
		super(header);
	}

}
