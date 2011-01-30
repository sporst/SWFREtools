package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArray;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing VideoFrame tags.
 * 
 * @author sp
 */
public final class VideoFrameParser {

	/**
	 * Parses a VideoFrame tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static VideoFrameTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 streamId = parseUINT16(parser, 0x00006, "VideoFrame::StreamId");
		final UINT16 frameNum = parseUINT16(parser, 0x00006, "VideoFrame::FrameNum");
		final ByteArray videoData = parseByteArray(parser, header.getNormalizedLength() - UINT16.LENGTH - UINT16.LENGTH, 0x00006, "VideoFrame::VideoData");

		return new VideoFrameTag(header, streamId, frameNum, videoData);
	}
}