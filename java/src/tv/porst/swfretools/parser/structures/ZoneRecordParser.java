package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ZoneRecord structures.
 * 
 * @author sp
 *
 */
public final class ZoneRecordParser {

	/**
	 * Parses a ZoneRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ZoneRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 numZoneData = parseUINT8(parser, 0x00006, fieldName + "::NumZoneData");

		final List<ZoneData> zoneData = new ArrayList<ZoneData>();

		for (int i=0;i<numZoneData.value();i++) {
			zoneData.add(ZoneDataParser.parse(parser, String.format("zoneData[%d]", i)));
		}

		final UBits reserved = parseUBits(parser, 6, 0x00006, fieldName + "::Reserved");
		final Flag zoneMaskY = parseFlag(parser, 0x00006, fieldName + "::ZoneMaskY");
		final Flag zoneMaskX = parseFlag(parser, 0x00006, fieldName + "::ZoneMaskX");

		return new ZoneRecord(numZoneData, new ZoneDataList(zoneData), reserved, zoneMaskY, zoneMaskX);
	}
}