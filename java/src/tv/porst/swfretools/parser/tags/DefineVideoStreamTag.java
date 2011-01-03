package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineVideoStreamTag extends Tag {

	public DefineVideoStreamTag(final RecordHeader header, final int characterID,
			final int numFrames, final int width, final int height, final int videoFlagsReserved,
			final int videoFlagsDeblocking, final boolean videoFlagsSmoothing, final int codecID) {
		super(header);
	}

}
