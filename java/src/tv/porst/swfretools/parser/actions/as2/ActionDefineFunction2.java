package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ActionList;

public class ActionDefineFunction2 extends ExtendedAction {

	private final AsciiString functionName;

	private final UINT16 numParams;

	private final UINT8 registerCount;

	private final Flag preloadParentFlag;

	private final Flag preloadRootFlag;

	private final Flag suppressSuperFlag;

	private final Flag preloadSuperFlag;

	private final Flag suppressArgumentsFlag;

	private final Flag preloadArgumentsFlag;

	private final Flag suppressThisFlag;

	private final Flag preloadThisFlag;

	private final UBits reserved;

	private final Flag preloadGlobalFlag;

	private final RegisterParamList registerParamList;

	private final UINT16 codeSize;

	private final ActionList actionList;

	public ActionDefineFunction2(final UINT8 actionCode, final UINT16 length, final AsciiString functionName,
			final UINT16 numParams, final UINT8 registerCount, final Flag preloadParentFlag, final Flag preloadRootFlag,
			final Flag suppressSuperFlag, final Flag preloadSuperFlag,
			final Flag suppressArgumentsFlag, final Flag preloadArgumentsFlag,
			final Flag suppressThisFlag, final Flag preloadThisFlag, final UBits reserved,
			final Flag preloadGlobalFlag, final RegisterParamList registerParamList,
			final UINT16 codeSize, final ActionList actionList) {
		super(actionCode, length);

		this.functionName = functionName;
		this.numParams = numParams;
		this.registerCount = registerCount;
		this.preloadParentFlag = preloadParentFlag;
		this.preloadRootFlag = preloadRootFlag;
		this.suppressSuperFlag = suppressSuperFlag;
		this.preloadSuperFlag = preloadSuperFlag;
		this.suppressArgumentsFlag = suppressArgumentsFlag;
		this.preloadArgumentsFlag = preloadArgumentsFlag;
		this.suppressThisFlag = suppressThisFlag;
		this.preloadThisFlag = preloadThisFlag;
		this.reserved = reserved;
		this.preloadGlobalFlag = preloadGlobalFlag;
		this.registerParamList = registerParamList;
		this.codeSize = codeSize;
		this.actionList = actionList;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getActionList() {
		return actionList;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), functionName, registerCount, preloadParentFlag,
				preloadRootFlag, suppressSuperFlag, preloadSuperFlag, suppressArgumentsFlag,
				preloadArgumentsFlag, suppressThisFlag, preloadThisFlag, reserved,
				preloadGlobalFlag, registerParamList, codeSize, actionList);
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getCodeSize() {
		return codeSize;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getFunctionName() {
		return functionName;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getNumParams() {
		return numParams;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadArgumentsFlag() {
		return preloadArgumentsFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadGlobalFlag() {
		return preloadGlobalFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadParentFlag() {
		return preloadParentFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadRootFlag() {
		return preloadRootFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadSuperFlag() {
		return preloadSuperFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPreloadThisFlag() {
		return preloadThisFlag;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getRegisterCount() {
		return registerCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public RegisterParamList getRegisterParamList() {
		return registerParamList;
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
	public Flag getSuppressArgumentsFlag() {
		return suppressArgumentsFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getSuppressSuperFlag() {
		return suppressSuperFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getSuppressThisFlag() {
		return suppressThisFlag;
	}
}