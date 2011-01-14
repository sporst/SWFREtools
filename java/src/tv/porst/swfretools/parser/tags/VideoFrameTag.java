package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a VideoFrame tag.
 * 
 * @author sp
 *
 */
public final class VideoFrameTag extends Tag {

	/**
	 * ID of video frame character of which this frame is a part.
	 */
	private UINT16 streamId;

	/**
	 * Sequence number of this frame within its video stream.
	 */
	private UINT16 frameNum;

	/**
	 * Video frame payload.
	 */
	private ByteArray videoData;

	/**
	 * Creates a new VideoFrame tag object.
	 * 
	 * @param header Tag header.
	 * @param streamId ID of video frame character of which this frame is a part.
	 * @param frameNum Sequence number of this frame within its video stream.
	 * @param videoData Video frame payload.
	 */
	public VideoFrameTag(final RecordHeader header, final UINT16 streamId,
			final UINT16 frameNum, final ByteArray videoData) {
		super(header);

		SWFParserHelpers.checkNull(streamId, "StreamId");
		SWFParserHelpers.checkNull(frameNum, "FrameNum");
		SWFParserHelpers.checkNull(videoData, "VideoData");

		this.streamId = streamId;
		this.frameNum = frameNum;
		this.videoData = videoData;
	}

	/**
	 * Returns the sequence number of this frame within its video stream.
	 * 
	 * @return The sequence number of this frame within its video stream.
	 */
	public UINT16 getFrameNum() {
		return frameNum;
	}

	/**
	 * Returns the ID of video frame character of which this frame is a part.
	 * 
	 * @return The ID of video frame character of which this frame is a part.
	 */
	public UINT16 getStreamId() {
		return streamId;
	}

	/**
	 * Returns the video frame payload.
	 * 
	 * @return The video frame payload.
	 */
	public ByteArray getVideoData() {
		return videoData;
	}

	/**
	 * Changes the the sequence number of this frame within its video stream.
	 * 
	 * @param frameNum The new sequence number.
	 */
	public void setFrameNum(final UINT16 frameNum) {

		SWFParserHelpers.checkNull(frameNum, "FrameNum");
		this.frameNum = frameNum;
	}

	/**
	 * Changes the the ID of video frame character of which this frame is a part.
	 * 
	 * @param streamId The new stream Id.
	 */
	public void setStreamId(final UINT16 streamId) {

		SWFParserHelpers.checkNull(streamId, "StreamId");
		this.streamId = streamId;
	}

	/**
	 * Changes the video frame payload.
	 * 
	 * @param videoData The new video frame payload.
	 */
	public void setVideoData(final ByteArray videoData) {

		SWFParserHelpers.checkNull(videoData, "VideoData");
		this.videoData = videoData;
	}
}
