package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;

public class PushedInteger extends PushedValue<UINT32> {

	public PushedInteger(final UINT8 type, final UINT32 value) {
		super(type, value);
	}

}
