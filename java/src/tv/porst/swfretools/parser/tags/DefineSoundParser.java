package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSoundParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int soundID = parser.readUInt16();
		final int soundFormat = parser.readBits(4);
		final int soundRate = parser.readBits(2);
		final int soundSize = parser.readBits(1);
		final int soundType = parser.readBits(1);
		final long soundSampleCount = parser.readUInt32();

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - 4;

		final byte[] soundData = BinaryParserHelpers.readByteArray(parser, remainingBytes);

		return new DefineSoundTag(header, soundID, soundFormat, soundRate, soundSize, soundType, soundSampleCount, soundData);
	}

}
