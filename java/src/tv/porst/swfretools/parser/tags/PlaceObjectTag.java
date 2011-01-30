package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a PlaceObject tag.
 * 
 * @author sp
 *
 */
public final class PlaceObjectTag extends Tag {

	/**
	 * ID of character to place.
	 */
	private final UINT16 characterId;

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * Transform matrix data.
	 */
	private final Matrix matrix;

	/**
	 * Color transform data.
	 */
	private final CxForm colorTransform;

	/**
	 * Creates a new PlaceObject tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID of character to place.
	 * @param depth Depth of character.
	 * @param matrix Transform matrix data.
	 * @param colorTransform Color transform data.
	 */
	public PlaceObjectTag(final RecordHeader header, final UINT16 characterId, final UINT16 depth, final Matrix matrix, final CxForm colorTransform) {
		super(header);

		SWFParserHelpers.checkNull(characterId, "CharacterId");
		SWFParserHelpers.checkNull(depth, "Depth");
		SWFParserHelpers.checkNull(matrix, "Matrix");
		SWFParserHelpers.checkNull(colorTransform, "ColorTransform");

		this.characterId = characterId;
		this.depth = depth;
		this.matrix = matrix;
		this.colorTransform = colorTransform;
	}

	/**
	 * Returns the ID of character to place.
	 * 
	 * @return The ID of character to place.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the color transform data.
	 * 
	 * @return The color transform data.
	 */
	public CxForm getColorTransform() {
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
}