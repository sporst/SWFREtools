package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ShapeList;
import tv.porst.swfretools.parser.structures.UINT16List;

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
	private final UINT16List offsetTable;

	/**
	 * Array of shapes.
	 */
	private final ShapeList glyphShapeTable;

	/**
	 * Creates a new DefineFont tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId ID of this font character.
	 * @param offsetTable Array of shape offsets.
	 * @param glyphShapeTable Array of shapes.
	 */
	public DefineFontTag(final RecordHeader header, final UINT16 fontId, final UINT16List offsetTable, final ShapeList glyphShapeTable) {
		super(header);

		this.fontId = fontId;
		this.offsetTable = offsetTable;
		this.glyphShapeTable = glyphShapeTable;
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
	public ShapeList getGlyphShapeTable() {
		return glyphShapeTable;
	}

	/**
	 * Returns the array of shape offsets.
	 * 
	 * @return The array of shape offsets.
	 */
	public UINT16List getOffsetTable() {
		return offsetTable;
	}
}