package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ClipActionRecord structure.
 * 
 * @author sp
 *
 */
public final class ClipActionRecord implements IFileElement {

	/**
	 * Events to which this handler applies.
	 */
	private final ClipEventFlags eventFlags;

	/**
	 * Offset in bytes from the end of this field to next ClipActionRecord.
	 */
	private final UINT32 actionRecordSize;

	/**
	 * Key code to trap.
	 */
	private final UINT8 keyCode;

	/**
	 * Actions to perform.
	 */
	private final ActionList actions;

	/**
	 * Creates a new ClipActionRecord object.
	 * 
	 * @param eventFlags Events to which this handler applies.
	 * @param actionRecordSize Offset in bytes from the end of this field to next ClipActionRecord.
	 * @param keyCode Key code to trap.
	 * @param actions Actions to perform.
	 */
	public ClipActionRecord(final ClipEventFlags eventFlags, final UINT32 actionRecordSize,
			final UINT8 keyCode, final ActionList actions) {

		this.eventFlags = eventFlags;
		this.actionRecordSize = actionRecordSize;
		this.keyCode = keyCode;
		this.actions = actions;
	}

	/**
	 * Returns the offset in bytes from the end of this field to next ClipActionRecord.
	 *
	 * @return The offset in bytes from the end of this field to next ClipActionRecord.
	 */
	public UINT32 getActionRecordSize() {
		return actionRecordSize;
	}

	/**
	 * Returns the actions to perform.
	 *
	 * @return The actions to perform.
	 */
	public ActionList getActions() {
		return actions;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(eventFlags, actionRecordSize, keyCode, actions);
	}

	@Override
	public int getBitPosition() {
		return eventFlags.getBitPosition();
	}

	/**
	 * Returns the events to which this handler applies.
	 *
	 * @return The events to which this handler applies.
	 */
	public ClipEventFlags getEventFlags() {
		return eventFlags;
	}

	/**
	 * Returns the key code to trap.
	 *
	 * @return The key code to trap.
	 */
	public UINT8 getKeyCode() {
		return keyCode;
	}
}