package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ZoneRecord;
import tv.porst.swfretools.parser.structures.ZoneRecordList;
import tv.porst.swfretools.parser.structures.ZoneRecordParser;

/**
 * Class for parsing DefineFontAlignZones tags.
 */
public final class DefineFontAlignZonesParser {

	/**
	 * Calculates the length in bytes of a zone record.
	 * 
	 * @param zoneRecord The zone record whose length is calculated.
	 * 
	 * @return The length of the zone record in bytes.
	 */
	private static int calculateLength(final ZoneRecord zoneRecord) {
		return 1 + zoneRecord.getZoneData().size() * 4 + 1;
	}

	/**
	 * Parses a DefineFontAlignZones tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFontAlignZonesTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineFontAlignZones::FontId");
		final UBits csmTableHint = parseUBits(parser, 2, 0x00006, "DefineFontAlignZones::CSMTableHint");
		final UBits reserved = parseUBits(parser, 6, 0x00006, "DefineFontAlignZones::Reserved");

		final List<ZoneRecord> zoneTable = new ArrayList<ZoneRecord>();

		int toParse = header.getNormalizedLength() - 2 - 1;

		while (toParse > 0) {
			final ZoneRecord zoneRecord = ZoneRecordParser.parse(parser, String.format("DefineFontAlignZones::ZoneTable[%d]", zoneTable.size()));
			zoneTable.add(zoneRecord);

			toParse -= calculateLength(zoneRecord);
		}

		return new DefineFontAlignZonesTag(header, fontId, csmTableHint, reserved, new ZoneRecordList(zoneTable));
	}
}