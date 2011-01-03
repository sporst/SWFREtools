package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;

public class DefineFontTag extends Tag {

	public DefineFontTag(final RecordHeader header, final int fontId, final List<Integer> offsetTable, final List<Shape> glyphShapeTable) {
		super(header);
	}

}
