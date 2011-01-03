package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class VideoFrameTag extends Tag {

	public VideoFrameTag(final RecordHeader header, final int streamID,
			final int frameNum, final byte[] videoData) {
		super(header);
	}

}
