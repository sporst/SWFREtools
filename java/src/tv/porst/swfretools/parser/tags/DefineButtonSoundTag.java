package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

public class DefineButtonSoundTag extends Tag {

	public DefineButtonSoundTag(final RecordHeader header, final int buttonID,
			final int buttonSoundChar0, final SoundInfo buttonSoundInfo0,
			final int buttonSoundChar1, final SoundInfo buttonSoundInfo1,
			final int buttonSoundChar2, final SoundInfo buttonSoundInfo2,
			final int buttonSoundChar3, final SoundInfo buttonSoundInfo3) {
		super(header);
	}

}
