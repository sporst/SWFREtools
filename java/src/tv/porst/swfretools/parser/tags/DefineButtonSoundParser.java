package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

/**
 * Class for parsing DefineButtonSound tags.
 */
public final class DefineButtonSoundParser {

	/**
	 * Parses a DefineButtonSound tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineButtonSoundTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 buttonId = parseUINT16(parser, 0x00006, "DefineButtonSound::ButtonId");
		final UINT16 buttonSoundChar0 = parseUINT16(parser, 0x00006, "DefineButtonSound::ButtonSoundChar0");
		final SoundInfo buttonSoundInfo0 = SoundInfoParser.parseIf(parser, buttonSoundChar0.value() != 0, "DefineButtonSound::ButtonSoundInfo0");
		final UINT16 buttonSoundChar1 = parseUINT16(parser, 0x00006, "DefineButtonSound::ButtonSoundChar1");
		final SoundInfo buttonSoundInfo1 = SoundInfoParser.parseIf(parser, buttonSoundChar1.value() != 0, "DefineButtonSound::ButtonSoundInfo1");
		final UINT16 buttonSoundChar2 = parseUINT16(parser, 0x00006, "DefineButtonSound::ButtonSoundChar2");
		final SoundInfo buttonSoundInfo2 = SoundInfoParser.parseIf(parser, buttonSoundChar2.value() != 0, "DefineButtonSound::ButtonSoundInfo2");
		final UINT16 buttonSoundChar3 = parseUINT16(parser, 0x00006, "DefineButtonSound::ButtonSoundChar3");
		final SoundInfo buttonSoundInfo3 = SoundInfoParser.parseIf(parser, buttonSoundChar3.value() != 0, "DefineButtonSound::ButtonSoundInfo3");

		return new DefineButtonSoundTag(header, buttonId, buttonSoundChar0, buttonSoundInfo0,
				buttonSoundChar1, buttonSoundInfo1, buttonSoundChar2, buttonSoundInfo2,
				buttonSoundChar3, buttonSoundInfo3);
	}
}