package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

public class DefineFontParser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 fontId = parser.readUInt16();

		final int numberOfGlyphs = parser.peekUInt16() / 2;

		final List<UINT16> offsetTable = new ArrayList<UINT16>();

		for (int i=0;i<numberOfGlyphs;i++) {
			offsetTable.add(parser.readUInt16());
		}

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numberOfGlyphs;i++) {
			glyphShapeTable.add(ShapeParser.parse(parser, String.format("GlyphShapeTable[%d]", i)));
		}

		return new DefineFontTag(header, fontId, offsetTable, glyphShapeTable);
	}

}
