package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineSoundTag extends Tag {

	public DefineSoundTag(final RecordHeader header, final UINT16 soundID, final Bits soundFormat,
			final Bits soundRate, final Bits soundSize, final Bits soundType, final UINT32 soundSampleCount,
			final ByteArray soundData) {
		super(header);
	}

}
