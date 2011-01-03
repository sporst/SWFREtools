package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

public class DefineButtonSoundTag extends Tag {

	public DefineButtonSoundTag(final RecordHeader header, final UINT16 buttonID,
			final UINT16 buttonSoundChar0, final SoundInfo buttonSoundInfo0,
			final UINT16 buttonSoundChar1, final SoundInfo buttonSoundInfo1,
			final UINT16 buttonSoundChar2, final SoundInfo buttonSoundInfo2,
			final UINT16 buttonSoundChar3, final SoundInfo buttonSoundInfo3) {
		super(header);
	}

}
