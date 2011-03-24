package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionWaitForFrame2 extends ExtendedAction {

	private final UINT8 skipCount;

	public ActionWaitForFrame2(final UINT8 actionCode, final UINT16 length, final UINT8 skipCount) {
		super(actionCode, length);

		this.skipCount = skipCount;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), skipCount);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getSkipCount() {
		return skipCount;
	}
}
