package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.IParsedINTElement;
import tv.porst.splib.io.UINT16;

/**
 * Represents a ClipActions structure.
 * 
 * @author sp
 *
 */
public final class ClipActions {

	/**
	 * Reserved bits.
	 */
	private final UINT16 reserved;

	/**
	 * All events used in these clip actions.
	 */
	private final ClipEventFlags allEventFlags;

	/**
	 * Individual event handlers.
	 */
	private final List<ClipActionRecord> clipActionRecords;

	/**
	 * Flag that ends the action record.
	 */
	private final IParsedINTElement clipActionEndFlag;

	/**
	 * Creates a new ClipActions object.
	 * 
	 * @param reserved Reserved bits.
	 * @param allEventFlags All events used in these clip actions.
	 * @param clipActionRecords Individual event handlers.
	 * @param clipActionEndFlag Flag that ends the action record.
	 */
	public ClipActions(final UINT16 reserved, final ClipEventFlags allEventFlags,
			final List<ClipActionRecord> clipActionRecords, final IParsedINTElement clipActionEndFlag) {

		this.reserved = reserved;
		this.allEventFlags = allEventFlags;
		this.clipActionRecords = new ArrayList<ClipActionRecord>(clipActionRecords);
		this.clipActionEndFlag = clipActionEndFlag;
	}

	/**
	 * Returns all events used in these clip actions.
	 *
	 * @return All events used in these clip actions.
	 */
	public ClipEventFlags getAllEventFlags() {
		return allEventFlags;
	}

	/**
	 * Returns the flag that ends the action record.
	 *
	 * @return The flag that ends the action record.
	 */
	public IParsedINTElement getClipActionEndFlag() {
		return clipActionEndFlag;
	}

	/**
	 * Returns the individual event handlers.
	 *
	 * @return The individual event handlers.
	 */
	public List<ClipActionRecord> getClipActionRecords() {
		return new ArrayList<ClipActionRecord>(clipActionRecords);
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UINT16 getReserved() {
		return reserved;
	}
}