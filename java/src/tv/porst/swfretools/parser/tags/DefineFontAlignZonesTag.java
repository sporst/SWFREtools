package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ZoneRecord;

public class DefineFontAlignZonesTag extends Tag {

	public DefineFontAlignZonesTag(final RecordHeader header, final UINT16 fontID,
			final int csmTableHint, final int reserved, final List<ZoneRecord> zoneTable) {
		super(header);
	}

}
