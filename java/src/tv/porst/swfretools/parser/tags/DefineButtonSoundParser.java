package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

public class DefineButtonSoundParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int buttonID = parser.readUInt16();
		final int buttonSoundChar0 = parser.readUInt16();
		final SoundInfo buttonSoundInfo0 = buttonSoundChar0 == 0 ? null : SoundInfoParser.parse(parser);
		final int buttonSoundChar1 = parser.readUInt16();
		final SoundInfo buttonSoundInfo1 = buttonSoundChar1 == 0 ? null : SoundInfoParser.parse(parser);
		final int buttonSoundChar2 = parser.readUInt16();
		final SoundInfo buttonSoundInfo2 = buttonSoundChar2 == 0 ? null : SoundInfoParser.parse(parser);
		final int buttonSoundChar3 = parser.readUInt16();
		final SoundInfo buttonSoundInfo3 = buttonSoundChar3 == 0 ? null : SoundInfoParser.parse(parser);

		return new DefineButtonSoundTag(header, buttonID, buttonSoundChar0, buttonSoundInfo0,
				buttonSoundChar1, buttonSoundInfo1, buttonSoundChar2, buttonSoundInfo2,
				buttonSoundChar3, buttonSoundInfo3);
	}

}
