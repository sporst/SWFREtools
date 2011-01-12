package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class JPEGTablesTag extends Tag {

	public JPEGTablesTag(final RecordHeader header, final ByteArray jpegData) {
		super(header);
	}

}
