package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;

public class ZoneRecord {

	private final ArrayList<ZoneData> zoneData;

	public ZoneRecord(final UINT8 numZoneData, final List<ZoneData> zoneData, final Bits reserved,
			final Flag zoneMaskY, final Flag zoneMaskX) {
		this.zoneData = new ArrayList<ZoneData>(zoneData);
	}

	public List<ZoneData> getZoneData() {
		return new ArrayList<ZoneData>(zoneData);
	}

}
