package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class VideoFrameTag extends Tag {

	public VideoFrameTag(final RecordHeader header, final UINT16 streamID,
			final UINT16 frameNum, final ByteArray videoData) {
		super(header);
	}

}
