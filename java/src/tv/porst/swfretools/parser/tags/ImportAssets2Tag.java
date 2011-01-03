package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ImportAssets2Tag extends Tag {

	public ImportAssets2Tag(final RecordHeader header, final PString url, final UINT8 reserved,
			final UINT8 reserved2, final UINT16 count, final List<AssetTag> tags) {
		super(header);
	}

}
