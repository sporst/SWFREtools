package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineSprite tags.
 */
public final class DefineSpriteParser {

	/**
	 * Parses a DefineSprite tag.
	 * 
	 * @param header Previously parsed header of the tag.
	 * @param parser Provides the input data.
	 * @param version Flash version number which was read from the SWF file header.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineSpriteTag parse(final RecordHeader header, final SWFBinaryParser parser, final int version) throws SWFParserException {

		final UINT16 spriteId = parseUINT16(parser, 0x00006, "DefineSprite::SpriteId");
		final UINT16 frameCount = parseUINT16(parser, 0x00006, "DefineSprite::FrameCount");

		final int length = header.getNormalizedLength() - 2 - 2;

		final TagParserResult parserResult = TagParser.parse(parser, version, length);

		return new DefineSpriteTag(header, spriteId, frameCount, parserResult.getTags());
	}
}