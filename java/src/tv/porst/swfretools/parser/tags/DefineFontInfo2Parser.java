package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ParsedINTElementList;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing DefineFontInfo2 tags.
 */
public final class DefineFontInfo2Parser {

	/**
	 * Parses a DefineFontInfo2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFontInfo2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineFontInfo2::FontId");
		final UINT8 fontNameLen = parseUINT8(parser, 0x00006, "DefineFontInfo2::FontNameLen");
		final AsciiString fontName = parseString(parser, fontNameLen.value(), 0x00006, "DefineFontInfo2::FontName");
		final UBits fontFlagsReserved = parseUBits(parser, 2, 0x00006, "DefineFontInfo2::FontFlagsReserved");
		final Flag fontFlagsSmallText = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsSmallText");
		final Flag fontFlagsShiftJIS = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsShiftJIS");
		final Flag fontFlagsANSI = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsANSI");
		final Flag fontFlagsItalic = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsItalic");
		final Flag fontFlagsBold = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsBold");
		final Flag fontFlagsWideCodes = parseFlag(parser, 0x00006, "DefineFontInfo2::FontFlagsWideCodes");
		final UINT8 languageCode = parseUINT8(parser, 0x00006, "DefineFont2::LanguageCode");

		final int remainingBytes = header.getNormalizedLength() - 2 - 1 - fontNameLen.value() - 1;

		final int numberOfGlyphs = remainingBytes / (fontFlagsWideCodes.value() ? 2 : 1);

		final List<IParsedINTElement> codeTable = new ArrayList<IParsedINTElement>();

		for (int i=0;i<numberOfGlyphs;i++) {
			if (fontFlagsWideCodes.value()) {
				codeTable.add(parseUINT16(parser, 0x00006, String.format("DefineFontInfo2::CodeTable[%d]", i)));
			}
			else {
				codeTable.add(parseUINT8(parser, 0x00006, String.format("DefineFontInfo2::CodeTable[%d]", i)));
			}
		}

		return new DefineFontInfo2Tag(header, fontId, fontNameLen, fontName,
				fontFlagsReserved, fontFlagsSmallText, fontFlagsShiftJIS,
				fontFlagsANSI, fontFlagsItalic, fontFlagsBold, fontFlagsWideCodes, languageCode, new ParsedINTElementList(codeTable));
	}
}