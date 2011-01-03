package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ZoneDataParser {

	public static ZoneData parse(final BinaryParser parser) {
		final float alignmentCoordinate = parser.readFloat16();
		final float range = parser.readFloat16();

		return new ZoneData(alignmentCoordinate, range);
	}

}
