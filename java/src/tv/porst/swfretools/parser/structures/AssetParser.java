package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class AssetParser {

	public static AssetTag parse(final BinaryParser parser) {
		final int tag = parser.readUInt16();
		final String name = parser.readString();

		return new AssetTag(tag, name);
	}

}
