package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseByteArrayIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineFont4 tags.
 * 
 * @author sp
 */
public final class DefineFont4Parser {

	/**
	 * Parses a DefineFont4 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFont4Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineText2::FontId");
		final Bits fontFlagsReserved = parseBits(parser, 5, 0x00006, "DefineFont4::FontFlagsReserved");
		final Flag fontFlagsHasFontData = parseFlag(parser, 0x00006, "DefineFont4::FontFlagsHasFontData");
		final Flag fontFlagsItalic = parseFlag(parser, 0x00006, "DefineFont4::FontFlagsItalic");
		final Flag fontFlagsBold = parseFlag(parser, 0x00006, "DefineFont4::FontFlagsBold");
		final PString fontName = parseString(parser, 0x00006, "DefineFont4::FontName");

		final int remainingLength = header.getNormalizedLength() - 1 - 1 - fontName.value().length() - 1;

		final ByteArray fontData = parseByteArrayIf(parser, remainingLength, 0x00006, fontFlagsHasFontData, "DefineFont4::FontData");

		return new DefineFont4Tag(header, fontId, fontFlagsReserved, fontFlagsItalic, fontFlagsBold, fontName, fontData);
	}
}