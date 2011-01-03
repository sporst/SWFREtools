package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

public class StartSoundTag extends Tag {

	public StartSoundTag(final RecordHeader header, final UINT16 soundID, final SoundInfo soundInfo) {
		super(header);
	}

}
