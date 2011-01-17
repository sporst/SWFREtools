package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape;

/**
 * Represents a DefineMorphShape2 tag.
 * 
 * @author sp
 *
 */
public final class DefineMorphShape2Tag extends Tag {

	/**
	 * ID of this character.
	 */
	private final UINT16 characterId;

	/**
	 * Bounds of the start shape.
	 */
	private final Rect startBounds;

	/**
	 * Bounds of the end shape.
	 */
	private final Rect endBounds;

	/**
	 * Bounds of the start shape, excluding strokes.
	 */
	private final Rect startEdgeBounds;

	/**
	 * Bounds of the end shape, excluding strokes.
	 */
	private final Rect endEdgeBounds;

	/**
	 * Reserved bits.
	 */
	private final Bits reserved;

	/**
	 * Non-scaling strokes flag.
	 */
	private final Flag usesNonScalingStrokes;

	/**
	 * Scaling strokes flag.
	 */
	private final Flag usesScalingStrokes;

	/**
	 * Indicates offset to EndEdges.
	 */
	private final UINT32 offset;

	/**
	 * Fill style information.
	 */
	private final MorphFillStyleArray morphFillStyles;

	/**
	 * Line style information.
	 */
	private final MorphLineStyleArray2 morphLineStyles;

	/**
	 * Contains the set of edges and the style bits that indicate style changes.
	 */
	private final Shape startEdges;

	/**
	 * Contains only the set of edges, with no style information.
	 */
	private final Shape endEdges;

	/**
	 * Creates a new DefineMorphShape tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID of this character.
	 * @param startBounds Bounds of the start shape.
	 * @param endBounds Bounds of the end shape.
	 * @param startEdgeBounds Bounds of the start shape, excluding strokes.
	 * @param endEdgeBounds Bounds of the end shape, excluding strokes.
	 * @param reserved Reserved bits.
	 * @param usesNonScalingStrokes Non-scaling strokes flag.
	 * @param usesScalingStrokes Scaling strokes flag.
	 * @param offset Indicates offset to EndEdges.
	 * @param morphFillStyles Fill style information.
	 * @param morphLineStyles Line style information.
	 * @param startEdges Contains the set of edges and the style bits that indicate style changes.
	 * @param endEdges Contains only the set of edges, with no style information.
	 */
	public DefineMorphShape2Tag(final RecordHeader header, final UINT16 characterId,
			final Rect startBounds, final Rect endBounds, final Rect startEdgeBounds,
			final Rect endEdgeBounds, final Bits reserved, final Flag usesNonScalingStrokes,
			final Flag usesScalingStrokes, final UINT32 offset,
			final MorphFillStyleArray morphFillStyles,
			final MorphLineStyleArray2 morphLineStyles, final Shape startEdges, final Shape endEdges) {

		super(header);

		this.characterId = characterId;
		this.startBounds = startBounds;
		this.endBounds = endBounds;
		this.startEdgeBounds = startEdgeBounds;
		this.endEdgeBounds = endEdgeBounds;
		this.reserved = reserved;
		this.usesNonScalingStrokes = usesNonScalingStrokes;
		this.usesScalingStrokes = usesScalingStrokes;
		this.offset = offset;
		this.morphFillStyles = morphFillStyles;
		this.morphLineStyles = morphLineStyles;
		this.startEdges = startEdges;
		this.endEdges = endEdges;
	}

	/**
	 * Returns the ID of this character.
	 * 
	 * @return The ID of this character.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the bounds of the end shape.
	 * 
	 * @return The bounds of the end shape.
	 */
	public Rect getEndBounds() {
		return endBounds;
	}

	/**
	 * Returns the bounds of the end shape, excluding strokes.
	 * 
	 * @return The bounds of the end shape, excluding strokes.
	 */
	public Rect getEndEdgeBounds() {
		return endEdgeBounds;
	}

	/**
	 * Returns only the set of edges, with no style information.
	 * 
	 * @return Only the set of edges, with no style information.
	 */
	public Shape getEndEdges() {
		return endEdges;
	}

	/**
	 * Returns the fill style information.
	 * 
	 * @return The fill style information.
	 */
	public MorphFillStyleArray getMorphFillStyles() {
		return morphFillStyles;
	}

	/**
	 * Returns the line style information.
	 * 
	 * @return The line style information.
	 */
	public MorphLineStyleArray2 getMorphLineStyles() {
		return morphLineStyles;
	}

	/**
	 * Returns the offset to EndEdges.
	 * 
	 * @return The offset to EndEdges.
	 */
	public UINT32 getOffset() {
		return offset;
	}

	/**
	 * Returns the reserved bit.
	 * 
	 * @return The reserved bit.
	 */
	public Bits getReserved() {
		return reserved;
	}

	/**
	 * Returns the bounds of the start shape.
	 * 
	 * @return The bounds of the start shape.
	 */
	public Rect getStartBounds() {
		return startBounds;
	}

	/**
	 * Returns the bounds of the start shape, excluding strokes.
	 * 
	 * @return The bounds of the start shape, excluding strokes.
	 */
	public Rect getStartEdgeBounds() {
		return startEdgeBounds;
	}

	/**
	 * Returns the set of edges and the style bits that indicate style changes.
	 * 
	 * @return The set of edges and the style bits that indicate style changes.
	 */
	public Shape getStartEdges() {
		return startEdges;
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