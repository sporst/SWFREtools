package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class VideoFrameParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 streamID = parser.readUInt16();
		final UINT16 frameNum = parser.readUInt16();
		final byte[] videoData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - 2 - 2);

		return new VideoFrameTag(header, streamID, frameNum, videoData);
	}

}
