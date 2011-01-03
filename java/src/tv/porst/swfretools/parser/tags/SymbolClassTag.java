package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SymbolClassTag extends Tag {

	public SymbolClassTag(final RecordHeader header, final UINT16 numSymbols,
			final List<AssetTag> tags) {
		super(header);
	}

}
