package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionGetURL2 extends ExtendedAction {

	private final UBits sendVarsMethod;
	private final UBits reserved;
	private final Flag loadTargetFlag;
	private final Flag loadVariablesFlag;

	public ActionGetURL2(final UINT8 actionCode, final UINT16 length, final UBits sendVarsMethod, final UBits reserved, final Flag loadTargetFlag, final Flag loadVariablesFlag) {
		super(actionCode, length);

		this.sendVarsMethod = sendVarsMethod;
		this.reserved = reserved;
		this.loadTargetFlag = loadTargetFlag;
		this.loadVariablesFlag = loadVariablesFlag;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), sendVarsMethod, reserved, loadTargetFlag, loadVariablesFlag);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getLoadTargetFlag() {
		return loadTargetFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getLoadVariablesFlag() {
		return loadVariablesFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UBits getSendVarsMethod() {
		return sendVarsMethod;
	}

}
