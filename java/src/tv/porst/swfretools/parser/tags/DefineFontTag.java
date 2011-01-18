package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Shape;

/**
 * Represents a DefineFont tag.
 * 
 * @author sp
 *
 */
public final class DefineFontTag extends Tag {

	/**
	 * ID of this font character.
	 */
	private final UINT16 fontId;

	/**
	 * Array of shape offsets.
	 */
	private final List<UINT16> offsetTable;

	/**
	 * Array of shapes.
	 */
	private final List<Shape> glyphShapeTable;

	/**
	 * Creates a new DefineFont tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId ID of this font character.
	 * @param offsetTable Array of shape offsets.
	 * @param glyphShapeTable Array of shapes.
	 */
	public DefineFontTag(final RecordHeader header, final UINT16 fontId, final List<UINT16> offsetTable, final List<Shape> glyphShapeTable) {
		super(header);

		this.fontId = fontId;
		this.offsetTable = new ArrayList<UINT16>(offsetTable);
		this.glyphShapeTable = new ArrayList<Shape>(glyphShapeTable);
	}

	/**
	 * Returns the ID of this font character.
	 * 
	 * @return The ID of this font character.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the array of shapes.
	 * 
	 * @return The array of shapes.
	 */
	public List<Shape> getGlyphShapeTable() {
		return new ArrayList<Shape>(glyphShapeTable);
	}

	/**
	 * Returns the array of shape offsets.
	 * 
	 * @return The array of shape offsets.
	 */
	public List<UINT16> getOffsetTable() {
		return new ArrayList<UINT16>(offsetTable);
	}
}