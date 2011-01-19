package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;

/**
 * Represents a ZoneRecord structure.
 * 
 * @author sp
 *
 */
public final class ZoneRecord {

	/**
	 * Number of ZoneData entries.
	 */
	private final UINT8 numZoneData;

	/**
	 * Compressed alignment zone information.
	 */
	private final ArrayList<ZoneData> zoneData;

	/**
	 * Reserved bits.
	 */
	private final Bits reserved;

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
	public ZoneRecord(final UINT8 numZoneData, final List<ZoneData> zoneData, final Bits reserved,
			final Flag zoneMaskY, final Flag zoneMaskX) {

		this.numZoneData = numZoneData;
		this.zoneData = new ArrayList<ZoneData>(zoneData);
		this.reserved = reserved;
		this.zoneMaskY = zoneMaskY;
		this.zoneMaskX = zoneMaskX;
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
	public Bits getReserved() {
		return reserved;
	}

	/**
	 * Returns the compressed alignment zone information.
	 * 
	 * @return The compressed alignment zone information.
	 */
	public List<ZoneData> getZoneData() {
		return new ArrayList<ZoneData>(zoneData);
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