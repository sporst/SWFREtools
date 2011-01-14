package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;

public class Pix15Parser {

	public static Pix15 parse(final BinaryParser parser) {
		final Bits pix15Reserved = parser.readBits(1);
		final Bits pix15Red = parser.readBits(5);
		final Bits pix15Green = parser.readBits(5);
		final Bits pix15Blue = parser.readBits(5);

		return new Pix15(pix15Reserved, pix15Red, pix15Blue, pix15Green);
	}

}
