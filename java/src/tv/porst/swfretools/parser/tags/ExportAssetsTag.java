package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ExportAssetsTag extends Tag {

	public ExportAssetsTag(final RecordHeader header, final int count, final List<AssetTag> tags) {
		super(header);
	}

}
