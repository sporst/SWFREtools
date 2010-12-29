package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class FixedParser {

	public static Fixed parse(final BinaryParser parser) {
		final int integer = parser.readUInt16();
		final int decimal = parser.readUInt16();

		return new Fixed(integer, decimal);
	}

}
