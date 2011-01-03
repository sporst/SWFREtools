package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

public class DefineFontParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int fontId = parser.readUInt16();

		final int numberOfGlyphs = parser.peekUInt16() / 2;

		final List<Integer> offsetTable = new ArrayList<Integer>();

		for (int i=0;i<numberOfGlyphs;i++) {
			offsetTable.add(parser.readUInt16());
		}

		final List<Shape> glyphShapeTable = new ArrayList<Shape>();

		for (int i=0;i<numberOfGlyphs;i++) {
			glyphShapeTable.add(ShapeParser.parse(parser));
		}

		return new DefineFontTag(header, fontId, offsetTable, glyphShapeTable);
	}

}
