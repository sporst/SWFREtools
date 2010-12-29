package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class Pix15Parser {

	public static Pix15 parse(final BinaryParser parser) {
		final int pix15Reserved = parser.readBits(1);
		final int pix15Red = parser.readBits(5);
		final int pix15Green = parser.readBits(5);
		final int pix15Blue = parser.readBits(5);

		return new Pix15(pix15Reserved, pix15Red, pix15Blue, pix15Green);
	}

}
