package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.UINT8;

public class PushedFloat extends PushedValue<Float32> {

	public PushedFloat(final UINT8 type, final Float32 value) {
		super(type, value);
	}

}
