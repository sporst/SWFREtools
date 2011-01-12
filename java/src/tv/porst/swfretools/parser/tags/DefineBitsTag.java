package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsTag extends Tag {

	public DefineBitsTag(final RecordHeader header, final UINT16 characterId, final ByteArray jpegData) {
		super(header);
	}

}
