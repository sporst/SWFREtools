package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FileAttributesParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int reserved = parser.readBits(1);
		final Flag useDirectBit = parser.readFlag();
		final Flag useGPU = parser.readFlag();
		final Flag hasMetadata = parser.readFlag();
		final Flag actionScript3 = parser.readFlag();
		final int reserved2 = parser.readBits(2);
		final Flag useNetwork = parser.readFlag();
		final int reserved3 = parser.readBits(24);

		return new FileAttributesTag(header, reserved, useDirectBit, useGPU, hasMetadata, actionScript3, reserved2, useNetwork, reserved3);
	}

}
