package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordParser;

public class DefineFontAlignZonesParser {

	private static int calculateLength(final ZoneRecord zoneRecord) {
		return 1 + zoneRecord.getZoneData().size() * 4 + 1;
	}

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 fontID = parser.readUInt16();
		final int csmTableHint = parser.readBits(2);
		final int reserved = parser.readBits(6);

		final List<ZoneRecord> zoneTable = new ArrayList<ZoneRecord>();

		int toParse = header.getNormalizedLength() - 1 - 1;

		while (toParse > 0) {
			final ZoneRecord zoneRecord = ZoneRecordParser.parse(parser);
			zoneTable.add(zoneRecord);

			toParse -= calculateLength(zoneRecord);
		}

		return new DefineFontAlignmentZonesTag(header, fontID, csmTableHint, reserved, zoneTable);
	}

}
