package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FileAttributesParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int reserved = parser.readBits(1);
		final boolean useDirectBit = parser.readFlag();
		final boolean useGPU = parser.readFlag();
		final boolean hasMetadata = parser.readFlag();
		final boolean actionScript3 = parser.readFlag();
		final int reserved2 = parser.readBits(2);
		final boolean useNetwork = parser.readFlag();
		final int reserved3 = parser.readBits(24);

		return new FileAttributesTag(header, reserved, useDirectBit, useGPU, hasMetadata, actionScript3, reserved2, useNetwork, reserved3);
	}

}
