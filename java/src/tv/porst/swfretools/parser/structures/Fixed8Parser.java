package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class Fixed8Parser {

	public static Fixed8 parse(final BinaryParser parser) {
		final UINT8 integer = parser.readUInt8();
		final UINT8 decimal = parser.readUInt8();

		return new Fixed8(integer, decimal);
	}

}
