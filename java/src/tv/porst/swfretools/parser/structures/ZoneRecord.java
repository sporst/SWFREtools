package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ZoneRecord structure.
 * 
 * @author sp
 *
 */
public final class ZoneRecord implements IFileElement {

	/**
	 * Number of ZoneData entries.
	 */
	private final UINT8 numZoneData;

	/**
	 * Compressed alignment zone information.
	 */
	private final ZoneDataList zoneData;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Set if there are Y alignment zones.
	 */
	private final Flag zoneMaskY;

	/**
	 * Set if there are X alignment zones.
	 */
	private final Flag zoneMaskX;

	/**
	 * Creates a new ZoneRecord object.
	 * 
	 * @param numZoneData Number of ZoneData entries.
	 * @param zoneData Compressed alignment zone information.
	 * @param reserved Reserved bits.
	 * @param zoneMaskY Set if there are Y alignment zones.
	 * @param zoneMaskX Set if there are X alignment zones.
	 */
	public ZoneRecord(final UINT8 numZoneData, final ZoneDataList zoneData, final UBits reserved,
			final Flag zoneMaskY, final Flag zoneMaskX) {

		this.numZoneData = numZoneData;
		this.zoneData = zoneData;
		this.reserved = reserved;
		this.zoneMaskY = zoneMaskY;
		this.zoneMaskX = zoneMaskX;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(numZoneData, zoneData, reserved, zoneMaskX, zoneMaskY);
	}

	@Override
	public int getBitPosition() {
		return numZoneData.getBitPosition();
	}

	/**
	 * Returns the number of ZoneData entries.
	 *
	 * @return The number of ZoneData entries.
	 */
	public UINT8 getNumZoneData() {
		return numZoneData;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the compressed alignment zone information.
	 * 
	 * @return The compressed alignment zone information.
	 */
	public ZoneDataList getZoneData() {
		return zoneData;
	}

	/**
	 * Returns the alignment zones X flag.
	 *
	 * @return The alignment zones X flag.
	 */
	public Flag getZoneMaskX() {
		return zoneMaskX;
	}

	/**
	 * Returns the alignment zones Y flag.
	 *
	 * @return The alignment zones Y flag.
	 */
	public Flag getZoneMaskY() {
		return zoneMaskY;
	}
}