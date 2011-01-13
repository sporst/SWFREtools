package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBinaryDataTag extends Tag {

	public DefineBinaryDataTag(final RecordHeader header, final UINT16 tag, final UINT32 reserved,
			final ByteArray data) {
		super(header);
	}

}
