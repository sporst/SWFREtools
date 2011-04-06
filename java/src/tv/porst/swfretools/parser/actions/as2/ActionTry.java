package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ActionList;


public class ActionTry extends Action {

	private final UINT16 length;
	private final UBits reserved;
	private final Flag catchInRegisterFlag;
	private final Flag finallyBlockFlag;
	private final Flag catchBlockFlag;
	private final UINT16 trySize;
	private final UINT16 catchSize;
	private final UINT16 finallySize;
	private final AsciiString catchName;
	private final UINT8 catchRegister;
	private final ActionList tryBody;
	private final ActionList catchBody;
	private final ActionList finallyBody;

	public ActionTry(final UINT8 actionCode, final UINT16 length, final UBits reserved,
			final Flag catchInRegisterFlag, final Flag finallyBlockFlag,
			final Flag catchBlockFlag, final UINT16 trySize, final UINT16 catchSize,
			final UINT16 finallySize, final AsciiString catchName, final UINT8 catchRegister,
			final ActionList tryBody, final ActionList catchBody,
			final ActionList finallyBody) {
		super(actionCode);

		this.length = length;
		this.reserved = reserved;
		this.catchInRegisterFlag = catchInRegisterFlag;
		this.finallyBlockFlag = finallyBlockFlag;
		this.catchBlockFlag = catchBlockFlag;
		this.trySize = trySize;
		this.catchSize = catchSize;
		this.finallySize = finallySize;
		this.catchName = catchName;
		this.catchRegister = catchRegister;
		this.tryBody = tryBody;
		this.catchBody = catchBody;
		this.finallyBody = finallyBody;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), length, reserved, catchInRegisterFlag,
				finallyBlockFlag, catchBlockFlag, trySize, catchSize, finallySize, catchName,
				catchRegister, tryBody, catchBody, finallyBody);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getCatchBlockFlag() {
		return catchBlockFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getCatchBody() {
		return catchBody;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getCatchInRegisterFlag() {
		return catchInRegisterFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getCatchName() {
		return catchName;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getCatchRegister() {
		return catchRegister;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getCatchSize() {
		return catchSize;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getFinallyBlockFlag() {
		return finallyBlockFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getFinallyBody() {
		return finallyBody;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getFinallySize() {
		return finallySize;
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
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getTryBody() {
		return tryBody;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getTrySize() {
		return trySize;
	}
}
