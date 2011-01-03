package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;

public class AssetParser {

	public static AssetTag parse(final BinaryParser parser) {
		final UINT16 tag = parser.readUInt16();
		final PString name = parser.readString();

		return new AssetTag(tag, name);
	}

}
