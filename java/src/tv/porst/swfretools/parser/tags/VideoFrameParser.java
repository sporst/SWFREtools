package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class VideoFrameParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int streamID = parser.readUInt16();
		final int frameNum = parser.readUInt16();
		final byte[] videoData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - 2 - 2);

		return new VideoFrameTag(header, streamID, frameNum, videoData);
	}

}
