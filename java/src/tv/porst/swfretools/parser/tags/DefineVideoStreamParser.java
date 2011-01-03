package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineVideoStreamParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterID = parser.readUInt16();
		final UINT16 numFrames = parser.readUInt16();
		final UINT16 width = parser.readUInt16();
		final UINT16 height = parser.readUInt16();
		final int videoFlagsReserved = parser.readBits(4);
		final int videoFlagsDeblocking = parser.readBits(3);
		final Flag videoFlagsSmoothing = parser.readFlag();
		final UINT8 codecID = parser.readUInt8();

		return new DefineVideoStreamTag(header, characterID, numFrames, width, height,
				videoFlagsReserved, videoFlagsDeblocking, videoFlagsSmoothing,
				codecID);

	}

}
