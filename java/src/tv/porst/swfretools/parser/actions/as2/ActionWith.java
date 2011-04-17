package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ActionList;

public class ActionWith extends ExtendedAction {

	private final UINT16 size;
	private final ActionList actions;

	public ActionWith(final UINT8 actionCode, final UINT16 length, final UINT16 size, final ActionList actions) {
		super(actionCode, length);

		this.size = size;
		this.actions = actions;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getActions() {
		return actions;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), size);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getSize() {
		return size;
	}
}
