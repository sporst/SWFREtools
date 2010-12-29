package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class Fixed8Parser {

	public static Fixed8 parse(final BinaryParser parser) {
		final int integer = parser.readUInt8();
		final int decimal = parser.readUInt8();

		return new Fixed8(integer, decimal);
	}

}
