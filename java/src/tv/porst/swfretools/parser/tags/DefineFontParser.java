package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

/**
 * Class for parsing DefineFont tags.
 * 
 * @author sp
 */
public final class DefineFontParser {

	/**
	 * Parses a DefineFont tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineFontTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 fontId = parseUINT16(parser, 0x00006, "DefineFont::FontId");

		final int numberOfGlyphs = parser.peekUInt16().value() / 2;

		final List<UINT16> offsetTable = new ArrayList<UINT16>();

		for (int i=0;i<numberOfGlyphs;i++) {
			offsetTable.add(parseUINT16(parser, 0x00006, String.format("DefineFont::OffsetTable[%d]", i)));
		}

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numberOfGlyphs;i++) {
			glyphShapeTable.add(ShapeParser.parse(parser, String.format("DefineFont::GlyphShapeTable[%d]", i)));
		}

		return new DefineFontTag(header, fontId, offsetTable, glyphShapeTable);
	}
}