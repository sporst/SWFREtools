package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.TextRecord2;
import tv.porst.swfretools.parser.structures.TextRecord2Parser;

/**
 * Class for parsing DefineText2 tags.
 * 
 * @author sp
 */
public final class DefineText2Parser {

	/**
	 * Parses a DefineText2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineText2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineText2::CharacterId");
		final Rect textBounds = RectParser.parse(parser, "DefineText2::TextBounds");
		final Matrix textMatrix = MatrixParser.parse(parser, "DefineText2::TextMatrix");
		final UINT8 glyphBits = parseUINT8(parser, 0x00006, "DefineText2::GlyphBits");
		final UINT8 advanceBits = parseUINT8(parser, 0x00006, "DefineText2::AdvanceBits");

		final List<TextRecord2> textRecords = new ArrayList<TextRecord2>();

		do {
			if (parser.peekUInt8().value() == 0) {
				break;
			}

			textRecords.add(TextRecord2Parser.parse(parser, glyphBits.value(), advanceBits.value(), String.format("DefineText::TextRecords2[%d]", textRecords.size())));

		} while (true);

		return new DefineText2Tag(header, characterId, textBounds, textMatrix, glyphBits, advanceBits, textRecords);
	}
}
