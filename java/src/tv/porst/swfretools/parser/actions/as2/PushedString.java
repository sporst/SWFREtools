package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT8;

public class PushedString extends PushedValue<AsciiString> {

	public PushedString(final UINT8 type, final AsciiString string) {
		super(type, string);
	}

}
