package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.AssetParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ExportAssetsParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {

		final int count = parser.readUInt16();

		final List<AssetTag> tags = new ArrayList<AssetTag>();

		for (int i=0;i<count;i++) {
			tags.add(AssetParser.parse(parser));
		}

		return new ExportAssetsTag(header, count, tags);
	}

}
