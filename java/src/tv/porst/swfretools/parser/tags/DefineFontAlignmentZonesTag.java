package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ZoneRecord;

public class DefineFontAlignmentZonesTag extends Tag {

	public DefineFontAlignmentZonesTag(final RecordHeader header, final int fontID,
			final int csmTableHint, final int reserved, final List<ZoneRecord> zoneTable) {
		super(header);
	}

}
