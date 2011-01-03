package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineVideoStreamParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterID = parser.readUInt16();
		final int numFrames = parser.readUInt16();
		final int width = parser.readUInt16();
		final int height = parser.readUInt16();
		final int videoFlagsReserved = parser.readBits(4);
		final int videoFlagsDeblocking = parser.readBits(3);
		final boolean videoFlagsSmoothing = parser.readFlag();
		final int codecID = parser.readUInt8();

		return new DefineVideoStreamTag(header, characterID, numFrames, width, height,
				videoFlagsReserved, videoFlagsDeblocking, videoFlagsSmoothing,
				codecID);

	}

}
