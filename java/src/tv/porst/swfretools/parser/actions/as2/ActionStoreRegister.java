package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionStoreRegister extends ExtendedAction {

	private final UINT8 registerNumber;

	public ActionStoreRegister(final UINT8 actionCode, final UINT16 length, final UINT8 registerNumber) {
		super(actionCode, length);

		this.registerNumber = registerNumber;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), registerNumber);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getRegisterNumber() {
		return registerNumber;
	}
}