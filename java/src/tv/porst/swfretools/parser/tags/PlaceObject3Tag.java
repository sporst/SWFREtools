package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a PlaceObject3 tag.
 * 
 * @author sp
 *
 */
public final class PlaceObject3Tag extends Tag {

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
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Has class name or character ID of bitmap to place.
	 */
	private final Flag placeFlagHasImage;

	/**
	 * Has class name of object to place.
	 */
	private final Flag placeFlagHasClassName;

	/**
	 * Enables bitmap caching.
	 */
	private final Flag placeFlagHasCacheAsBitmap;

	/**
	 * Has blend mode.
	 */
	private final Flag placeFlagHasBlendMode;

	/**
	 * Has filter list mode.
	 */
	private final Flag placeFlagHasFilterList;

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * Name of the class to place.
	 */
	private final AsciiString className;

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
	 * List of filters on this object.
	 */
	private final FilterList surfaceFilterList;

	/**
	 * Blend mode.
	 */
	private final UINT8 blendMode;

	/**
	 * Bitmap cache.
	 */
	private final UINT8 bitmapCache;

	/**
	 * Clip actions data.
	 */
	private final ClipActions clipActions;

	/**
	 * Creates a new PlaceObject3 tag object.
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
	 * @param reserved Reserved bits.
	 * @param placeFlagHasImage Has class name or character ID of bitmap to place.
	 * @param placeFlagHasClassName Has class name of object to place.
	 * @param placeFlagHasCacheAsBitmap Enables bitmap caching.
	 * @param placeFlagHasBlendMode Has blend mode.
	 * @param placeFlagHasFilterList Has filter list.
	 * @param depth Depth of character.
	 * @param className Name of the class to place.
	 * @param characterId ID of the character to place.
	 * @param matrix Transform matrix data.
	 * @param colorTransform Color transform data.
	 * @param ratio Ratio.
	 * @param name Name of character.
	 * @param clipDepth Clip depth.
	 * @param surfaceFilterList List of filters on this object.
	 * @param blendMode Blend mode.
	 * @param bitmapCache Bitmap cache.
	 * @param clipActions Clip actions data.
	 */
	public PlaceObject3Tag(final RecordHeader header,
			final Flag placeFlagHasClipActions, final Flag placeFlagHasClipDepth,
			final Flag placeFlagHasName, final Flag placeFlagHasRatio,
			final Flag placeFlagHasColorTransform, final Flag placeFlagHasMatrix,
			final Flag placeFlagHasCharacter, final Flag placeFlagHasMove,
			final UBits reserved, final Flag placeFlagHasImage, final Flag placeFlagHasClassName,
			final Flag placeFlagHasCacheAsBitmap, final Flag placeFlagHasBlendMode,
			final Flag placeFlagHasFilterList, final UINT16 depth, final AsciiString className, final UINT16 characterId,
			final Matrix matrix, final CxFormWithAlpha colorTransform, final UINT16 ratio,
			final AsciiString name, final UINT16 clipDepth, final FilterList surfaceFilterList,
			final UINT8 blendMode, final UINT8 bitmapCache, final ClipActions clipActions) {

		super(header);

		this.placeFlagHasClipActions = placeFlagHasClipActions;
		this.placeFlagHasClipDepth = placeFlagHasClipDepth;
		this.placeFlagHasName = placeFlagHasName;
		this.placeFlagHasRatio = placeFlagHasRatio;
		this.placeFlagHasColorTransform = placeFlagHasColorTransform;
		this.placeFlagHasMatrix = placeFlagHasMatrix;
		this.placeFlagHasCharacter = placeFlagHasCharacter;
		this.placeFlagHasMove = placeFlagHasMove;
		this.reserved = reserved;
		this.placeFlagHasImage = placeFlagHasImage;
		this.placeFlagHasClassName = placeFlagHasClassName;
		this.placeFlagHasCacheAsBitmap = placeFlagHasCacheAsBitmap;
		this.placeFlagHasBlendMode = placeFlagHasBlendMode;
		this.placeFlagHasFilterList = placeFlagHasFilterList;
		this.depth = depth;
		this.className = className;
		this.characterId = characterId;
		this.matrix = matrix;
		this.colorTransform = colorTransform;
		this.ratio = ratio;
		this.name = name;
		this.clipDepth = clipDepth;
		this.surfaceFilterList = surfaceFilterList;
		this.blendMode = blendMode;
		this.bitmapCache = bitmapCache;
		this.clipActions = clipActions;
	}

	/**
	 * Returns the bitmap cache.
	 * 
	 * @return The bitmap cache.
	 */
	public UINT8 getBitmapCache() {
		return bitmapCache;
	}

	/**
	 * Returns the blend mode.
	 * 
	 * @return The blend mode.
	 */
	public UINT8 getBlendMode() {
		return blendMode;
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
	 * Returns the name of the class to place.
	 * 
	 * @return The name of the class to place.
	 */
	public AsciiString getClassName() {
		return className;
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
	 * Returns the blend mode flag.
	 * 
	 * @return The blend mode flag.
	 */
	public Flag getPlaceFlagHasBlendMode() {
		return placeFlagHasBlendMode;
	}

	/**
	 * Returns the cache as bitmap flag.
	 * 
	 * @return The cache as bitmap flag.
	 */
	public Flag getPlaceFlagHasCacheAsBitmap() {
		return placeFlagHasCacheAsBitmap;
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
	 * Returns the class name flag.
	 * 
	 * @return The class name flag.
	 */
	public Flag getPlaceFlagHasClassName() {
		return placeFlagHasClassName;
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
	 * Returns the has filter list mode.
	 *
	 * @return The has filter list mode.
	 */
	public Flag getPlaceFlagHasFilterList() {
		return placeFlagHasFilterList;
	}

	/**
	 * Returns the image flag.
	 * 
	 * @return The image flag.
	 */
	public Flag getPlaceFlagHasImage() {
		return placeFlagHasImage;
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

	/**
	 * Returns the reserved bits.
	 * 
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the list of filters on this object.
	 * 
	 * @return The list of filters on this object.
	 */
	public FilterList getSurfaceFilterList() {
		return surfaceFilterList;
	}
}