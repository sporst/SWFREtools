package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;

/**
 * Represents a DefineShape3 tag.
 * 
 * @author sp
 *
 */
public final class DefineShape3Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final Rect shapeBounds;

	/**
	 * Bounds of the shape.
	 */
	private final UINT16 shapeId;

	/**
	 * Shape information.
	 */
	private final ShapeWithStyle3 shapes;

	/**
	 * Creates a new DefineShape3 tag object.
	 * 
	 * @param header Tag header.
	 * @param shapeId ID for this character.
	 * @param shapeBounds Bounds of the shape.
	 * @param shapes Shape information.
	 */
	public DefineShape3Tag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds, final ShapeWithStyle3 shapes) {
		super(header);

		this.shapeId = shapeId;
		this.shapeBounds = shapeBounds;
		this.shapes = shapes;
	}

	/**
	 * Returns the bounds of the shape.
	 * 
	 * @return The bounds of the shape.
	 */
	public Rect getShapeBounds() {
		return shapeBounds;
	}

	/**
	 * Returns the ID for this character.
	 * 
	 * @return The ID for this character.
	 */
	public UINT16 getShapeId() {
		return shapeId;
	}

	/**
	 * Returns the shape information.
	 * 
	 * @return The shape information.
	 */
	public ShapeWithStyle3 getShapes() {
		return shapes;
	}
}