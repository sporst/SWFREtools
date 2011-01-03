package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

public class ZoneRecord {

	private final ArrayList<ZoneData> zoneData;

	public ZoneRecord(final int numZoneData, final List<ZoneData> zoneData, final int reserved,
			final boolean zoneMaskY, final boolean zoneMaskX) {
		this.zoneData = new ArrayList<ZoneData>(zoneData);
	}

	public List<ZoneData> getZoneData() {
		return new ArrayList<ZoneData>(zoneData);
	}

}
