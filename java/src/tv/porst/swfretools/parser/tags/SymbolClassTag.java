package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SymbolClassTag extends Tag {

	public SymbolClassTag(final RecordHeader header, final int numSymbols,
			final List<AssetTag> tags) {
		super(header);
	}

}
