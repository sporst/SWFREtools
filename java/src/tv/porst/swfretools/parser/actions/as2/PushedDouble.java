package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.Float64;
import tv.porst.splib.binaryparser.UINT8;

public class PushedDouble extends PushedValue<Float64> {

	public PushedDouble(final UINT8 type, final Float64 value) {
		super(type, value);
	}

}
