package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class RegisterParam implements IFileElement {

	private final UINT8 register;
	private final AsciiString paramName;

	public RegisterParam(final UINT8 register, final AsciiString paramName) {
		this.register = register;
		this.paramName = paramName;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(register, paramName);
	}

	@Override
	public int getBitPosition() {
		return register.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getParamName() {
		return paramName;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getRegister() {
		return register;
	}

}
