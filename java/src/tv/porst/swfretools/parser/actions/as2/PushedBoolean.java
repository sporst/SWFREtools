package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT8;

public class PushedBoolean extends PushedValue<UINT8> {

	public PushedBoolean(final UINT8 type, final UINT8 bool) {
		super(type, bool);
	}

}
