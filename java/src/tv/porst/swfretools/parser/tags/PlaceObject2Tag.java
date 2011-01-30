package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a PlaceObject2 tag.
 * 
 * @author sp
 *
 */
public final class PlaceObject2Tag extends Tag {

	/**
	 * Has clip actions.
	 */
	private final Flag placeFlagHasClipActions;

	/**
	 * Has clip depth.
	 */
	private final Flag placeFlagHasClipDepth;

	/**
	 * Has name.
	 */
	private final Flag placeFlagHasName;

	/**
	 * Has ratio.
	 */
	private final Flag placeFlagHasRatio;

	/**
	 * Has color transform.
	 */
	private final Flag placeFlagHasColorTransform;

	/**
	 * Has matrix.
	 */
	private final Flag placeFlagHasMatrix;

	/**
	 * Has character.
	 */
	private final Flag placeFlagHasCharacter;

	/**
	 * Has move.
	 */
	private final Flag placeFlagHasMove;

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * ID of the character to place.
	 */
	private final UINT16 characterId;

	/**
	 * Transform matrix data.
	 */
	private final Matrix matrix;

	/**
	 * Color transform data.
	 */
	private final CxFormWithAlpha colorTransform;

	/**
	 * Ratio.
	 */
	private final UINT16 ratio;

	/**
	 * Name of character.
	 */
	private final AsciiString name;

	/**
	 * Clip depth.
	 */
	private final UINT16 clipDepth;

	/**
	 * Clip actions data.
	 */
	private final ClipActions clipActions;

	/**
	 * Creates a new PlaceObject2 tag object.
	 * 
	 * @param header Tag header.
	 * @param placeFlagHasClipActions Has clip actions.
	 * @param placeFlagHasClipDepth Has clip depth.
	 * @param placeFlagHasName Has name.
	 * @param placeFlagHasRatio Has ratio.
	 * @param placeFlagHasColorTransform Has color transform.
	 * @param placeFlagHasMatrix Has matrix.
	 * @param placeFlagHasCharacter Places a character.
	 * @param placeFlagHasMove Defines a character to be moved.
	 * @param depth Depth of character.
	 * @param characterId ID of the character to place.
	 * @param matrix Transform matrix data.
	 * @param colorTransform Color transform data.
	 * @param ratio Ratio.
	 * @param name Name of character.
	 * @param clipDepth Clip depth.
	 * @param clipActions Clip actions data.
	 */
	public PlaceObject2Tag(final RecordHeader header, final Flag placeFlagHasClipActions,
			final Flag placeFlagHasClipDepth, final Flag placeFlagHasName,
			final Flag placeFlagHasRatio, final Flag placeFlagHasColorTransform,
			final Flag placeFlagHasMatrix, final Flag placeFlagHasCharacter,
			final Flag placeFlagHasMove, final UINT16 depth, final UINT16 characterId, final Matrix matrix,
			final CxFormWithAlpha colorTransform, final UINT16 ratio, final AsciiString name,
			final UINT16 clipDepth, final ClipActions clipActions) {

		super(header);

		this.placeFlagHasClipActions = placeFlagHasClipActions;
		this.placeFlagHasClipDepth = placeFlagHasClipDepth;
		this.placeFlagHasName = placeFlagHasName;
		this.placeFlagHasRatio = placeFlagHasRatio;
		this.placeFlagHasColorTransform = placeFlagHasColorTransform;
		this.placeFlagHasMatrix = placeFlagHasMatrix;
		this.placeFlagHasCharacter = placeFlagHasCharacter;
		this.placeFlagHasMove = placeFlagHasMove;
		this.depth = depth;
		this.characterId = characterId;
		this.matrix = matrix;
		this.colorTransform = colorTransform;
		this.ratio = ratio;
		this.name = name;
		this.clipDepth = clipDepth;
		this.clipActions = clipActions;
	}

	/**
	 * Returns the ID of the character to place.
	 * 
	 * @return The ID of the character to place.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the clip actions data.
	 * 
	 * @return The clip actions data.
	 */
	public ClipActions getClipActions() {
		return clipActions;
	}

	/**
	 * Returns the clip depth.
	 * 
	 * @return The clip depth.
	 */
	public UINT16 getClipDepth() {
		return clipDepth;
	}

	/**
	 * Returns the color transform data.
	 * 
	 * @return The color transform data.
	 */
	public CxFormWithAlpha getColorTransform() {
		return colorTransform;
	}

	/**
	 * Returns the depth of character.
	 * 
	 * @return The depth of character.
	 */
	public UINT16 getDepth() {
		return depth;
	}

	/**
	 * Returns the transform matrix data.
	 * 
	 * @return The transform matrix data.
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * Returns the name of character.
	 * 
	 * @return The name of character.
	 */
	public AsciiString getName() {
		return name;
	}

	/**
	 * Returns the character flag.
	 * 
	 * @return The character flag.
	 */
	public Flag getPlaceFlagHasCharacter() {
		return placeFlagHasCharacter;
	}

	/**
	 * Returns the clip actions flag.
	 * 
	 * @return The clip actions flag.
	 */
	public Flag getPlaceFlagHasClipActions() {
		return placeFlagHasClipActions;
	}

	/**
	 * Returns the clip depth flag.
	 * 
	 * @return The clip depth flag.
	 */
	public Flag getPlaceFlagHasClipDepth() {
		return placeFlagHasClipDepth;
	}

	/**
	 * Returns the color transform flag.
	 * 
	 * @return The color transform flag.
	 */
	public Flag getPlaceFlagHasColorTransform() {
		return placeFlagHasColorTransform;
	}

	/**
	 * Returns the matrix flag.
	 * 
	 * @return The matrix flag.
	 */
	public Flag getPlaceFlagHasMatrix() {
		return placeFlagHasMatrix;
	}

	/**
	 * Returns the move flag.
	 * 
	 * @return The move flag.
	 */
	public Flag getPlaceFlagHasMove() {
		return placeFlagHasMove;
	}

	/**
	 * Returns the name flag.
	 * 
	 * @return The name flag.
	 */
	public Flag getPlaceFlagHasName() {
		return placeFlagHasName;
	}

	/**
	 * Returns the ratio flag.
	 * 
	 * @return The ratio flag.
	 */
	public Flag getPlaceFlagHasRatio() {
		return placeFlagHasRatio;
	}

	/**
	 * Returns the ratio.
	 * 
	 * @return The ratio.
	 */
	public UINT16 getRatio() {
		return ratio;
	}
}
