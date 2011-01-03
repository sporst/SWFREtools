package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

public class StartSoundParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 soundID = parser.readUInt16();
		final SoundInfo soundInfo = SoundInfoParser.parse(parser);

		return new StartSoundTag(header, soundID, soundInfo);
	}

}
