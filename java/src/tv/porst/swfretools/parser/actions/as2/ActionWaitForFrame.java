package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionWaitForFrame extends ExtendedAction {

	private final UINT16 frame;
	private final UINT8 skipCount;

	public ActionWaitForFrame(final UINT8 actionCode, final UINT16 length, final UINT16 frame, final UINT8 skipCount) {
		super(actionCode, length);

		this.frame = frame;
		this.skipCount = skipCount;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), frame, skipCount);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getFrame() {
		return frame;
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
