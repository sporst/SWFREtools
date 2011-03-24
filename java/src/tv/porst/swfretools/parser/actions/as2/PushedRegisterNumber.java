package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT8;

public class PushedRegisterNumber extends PushedValue<UINT8> {

	public PushedRegisterNumber(final UINT8 type, final UINT8 value) {
		super(type, value);
	}

}
