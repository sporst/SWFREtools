package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionPush extends Action {

	private final UINT16 length;
	private final PushedValueList pushedValueList;

	public ActionPush(final UINT8 actionCode, final UINT16 length, final PushedValueList pushedValueList) {
		super(actionCode);

		this.length = length;
		this.pushedValueList = pushedValueList;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), length, pushedValueList);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getLength() {
		return length;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public PushedValueList getPushedValueList() {
		return pushedValueList;
	}
}