package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.Shape;

/**
 * Represents a DefineMorphShape tag.
 * 
 * @author sp
 *
 */
public final class DefineMorphShapeTag extends Tag {

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
	private final MorphLineStyleArray morphLineStyles;

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
	 * @param offset Indicates offset to EndEdges.
	 * @param morphFillStyles Fill style information.
	 * @param morphLineStyles Line style information.
	 * @param startEdges Contains the set of edges and the style bits that indicate style changes.
	 * @param endEdges Contains only the set of edges, with no style information.
	 */
	public DefineMorphShapeTag(final RecordHeader header, final UINT16 characterId, final Rect startBounds,
			final Rect endBounds, final UINT32 offset, final MorphFillStyleArray morphFillStyles,
			final MorphLineStyleArray morphLineStyles, final Shape startEdges, final Shape endEdges) {
		super(header);

		this.characterId = characterId;
		this.startBounds = startBounds;
		this.endBounds = endBounds;
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
	public MorphLineStyleArray getMorphLineStyles() {
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
	 * Returns the bounds of the start shape.
	 * 
	 * @return The bounds of the start shape.
	 */
	public Rect getStartBounds() {
		return startBounds;
	}

	/**
	 * Returns the set of edges and the style bits that indicate style changes.
	 * 
	 * @return The set of edges and the style bits that indicate style changes.
	 */
	public Shape getStartEdges() {
		return startEdges;
	}
}