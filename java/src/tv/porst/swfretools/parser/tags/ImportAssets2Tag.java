package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ImportAssets2Tag extends Tag {

	public ImportAssets2Tag(final RecordHeader header, final String url, final int reserved,
			final int reserved2, final int count, final List<AssetTag> tags) {
		super(header);
	}

}
