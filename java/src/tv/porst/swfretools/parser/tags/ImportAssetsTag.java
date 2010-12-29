package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ImportAssetsTag extends Tag {

	public ImportAssetsTag(final RecordHeader header, final String url, final int count, final List<AssetTag> tags) {
		super(header);
	}

}
