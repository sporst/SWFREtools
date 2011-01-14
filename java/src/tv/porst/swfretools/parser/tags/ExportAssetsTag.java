package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.Symbol;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class ExportAssetsTag extends Tag {

	public ExportAssetsTag(final RecordHeader header, final UINT16 count, final List<Symbol> tags) {
		super(header);
	}

}
