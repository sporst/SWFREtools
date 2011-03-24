package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

public class PushedConstant16 extends PushedValue<UINT16> {

	public PushedConstant16(final UINT8 type, final UINT16 value) {
		super(type, value);
	}

}
