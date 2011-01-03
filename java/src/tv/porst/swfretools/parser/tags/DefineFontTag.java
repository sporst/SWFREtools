package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;

public class DefineFontTag extends Tag {

	public DefineFontTag(final RecordHeader header, final UINT16 fontId, final List<UINT16> offsetTable, final List<Shape> glyphShapeTable) {
		super(header);
	}

}
