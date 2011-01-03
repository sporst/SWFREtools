package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class ZoneRecordParser {

	public static ZoneRecord parse(final BinaryParser parser) {
		final UINT8 numZoneData = parser.readUInt8();

		final List<ZoneData> zoneData = new ArrayList<ZoneData>();

		for (int i=0;i<numZoneData.value();i++) {
			zoneData.add(ZoneDataParser.parse(parser));
		}

		final int reserved = parser.readBits(6);
		final boolean zoneMaskY = parser.readFlag();
		final boolean zoneMaskX = parser.readFlag();

		return new ZoneRecord(numZoneData, zoneData, reserved, zoneMaskY, zoneMaskX);
	}

}
