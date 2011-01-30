package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.Action;

/**
 * Represents a ClipActionRecord structure.
 * 
 * @author sp
 *
 */
public final class ClipActionRecord {

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
	private final List<Action> actions;

	/**
	 * Creates a new ClipActionRecord object.
	 * 
	 * @param eventFlags Events to which this handler applies.
	 * @param actionRecordSize Offset in bytes from the end of this field to next ClipActionRecord.
	 * @param keyCode Key code to trap.
	 * @param actions Actions to perform.
	 */
	public ClipActionRecord(final ClipEventFlags eventFlags, final UINT32 actionRecordSize,
			final UINT8 keyCode, final List<Action> actions) {

		this.eventFlags = eventFlags;
		this.actionRecordSize = actionRecordSize;
		this.keyCode = keyCode;
		this.actions = new ArrayList<Action>(actions);
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
	public List<Action> getActions() {
		return new ArrayList<Action>(actions);
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