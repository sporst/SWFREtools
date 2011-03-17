package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ClipActions structure.
 * 
 * @author sp
 *
 */
public final class ClipActions implements IFileElement {

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
	private final ClipActionRecordList clipActionRecords;

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
			final ClipActionRecordList clipActionRecords, final IParsedINTElement clipActionEndFlag) {

		this.reserved = reserved;
		this.allEventFlags = allEventFlags;
		this.clipActionRecords = clipActionRecords;
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

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(reserved, allEventFlags, clipActionRecords, clipActionEndFlag);
	}

	@Override
	public int getBitPosition() {
		return reserved.getBitPosition();
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
	public ClipActionRecordList getClipActionRecords() {
		return clipActionRecords;
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