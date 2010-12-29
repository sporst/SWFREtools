package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class Pix24Parser {

	public static Pix24 parse(final BinaryParser parser) {
		final int pix24Reserved = parser.readUInt8();
		final int pix24Red = parser.readUInt8();
		final int pix24Green = parser.readUInt8();
		final int pix24Blue = parser.readUInt8();

		return new Pix24(pix24Reserved, pix24Red, pix24Blue, pix24Green);
	}

}
