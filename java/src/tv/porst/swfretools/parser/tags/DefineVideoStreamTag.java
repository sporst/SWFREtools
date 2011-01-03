package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineVideoStreamTag extends Tag {

	public DefineVideoStreamTag(final RecordHeader header, final UINT16 characterID,
			final UINT16 numFrames, final UINT16 width, final UINT16 height, final int videoFlagsReserved,
			final int videoFlagsDeblocking, final Flag videoFlagsSmoothing, final UINT8 codecID) {
		super(header);
	}

}
