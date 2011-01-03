package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;

public class FixedParser {

	public static Fixed parse(final BinaryParser parser) {
		final UINT16 integer = parser.readUInt16();
		final UINT16 decimal = parser.readUInt16();

		return new Fixed(integer, decimal);
	}

}
