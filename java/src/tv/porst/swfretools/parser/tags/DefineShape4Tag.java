package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;

/**
 * Represents a DefineShape4 tag.
 * 
 * @author sp
 *
 */
public final class DefineShape4Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final Rect shapeBounds;

	/**
	 * Bounds of the shape.
	 */
	private final UINT16 shapeId;

	/**
	 * Bounds of the shape, excluding strokes.
	 */
	private final Rect edgeBounds;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Fill winding rule flag.
	 */
	private final Flag usesFillWindingRule;

	/**
	 * Non-scaling strokes flag.
	 */
	private final Flag usesNonScalingStrokes;

	/**
	 * Scaling strokes flag.
	 */
	private final Flag usesScalingStrokes;

	/**
	 * Shape information.
	 */
	private final ShapeWithStyle4 shapes;

	/**
	 * Creates a new DefineShape tag object.
	 * 
	 * @param header Tag header.
	 * @param shapeId ID for this character.
	 * @param shapeBounds Bounds of the shape.
	 * @param edgeBounds Bounds of the shape, excluding strokes.
	 * @param reserved Reserved bits.
	 * @param usesFillWindingRule Fill winding rule flag.
	 * @param usesNonScalingStrokes Non-scaling strokes flag.
	 * @param usesScalingStrokes Scaling strokes flag.
	 * @param shapes Shape information.
	 */
	public DefineShape4Tag(final RecordHeader header, final UINT16 shapeId, final Rect shapeBounds,
			final Rect edgeBounds, final UBits reserved, final Flag usesFillWindingRule,
			final Flag usesNonScalingStrokes, final Flag usesScalingStrokes, final ShapeWithStyle4 shapes) {
		super(header);

		this.shapeId = shapeId;
		this.shapeBounds = shapeBounds;
		this.edgeBounds = edgeBounds;
		this.reserved = reserved;
		this.usesFillWindingRule = usesFillWindingRule;
		this.usesNonScalingStrokes = usesNonScalingStrokes;
		this.usesScalingStrokes = usesScalingStrokes;
		this.shapes = shapes;
	}

	/**
	 * Returns the bounds of the shape, excluding strokes.
	 * 
	 * @return The bounds of the shape, excluding strokes.
	 */
	public Rect getEdgeBounds() {
		return edgeBounds;
	}

	/**
	 * Returns the reserved bits.
	 * 
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
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
	public ShapeWithStyle4 getShapes() {
		return shapes;
	}

	/**
	 * Returns the fill winding rule flag.
	 * 
	 * @return The fill winding rule flag.
	 */
	public Flag getUsesFillWindingRule() {
		return usesFillWindingRule;
	}

	/**
	 * Returns the non-scaling strokes flag.
	 * 
	 * @return The non-scaling strokes flag.
	 */
	public Flag getUsesNonScalingStrokes() {
		return usesNonScalingStrokes;
	}

	/**
	 * Returns the scaling strokes flag.
	 * 
	 * @return The scaling strokes flag.
	 */
	public Flag getUsesScalingStrokes() {
		return usesScalingStrokes;
	}
}