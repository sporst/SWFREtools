package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;

/**
 * Represents a DefineScalingGrid tag.
 * 
 * @author sp
 *
 */
public final class DefineScalingGridTag extends Tag {

	/**
	 * ID of sprite or button character upon which the scaling grid will be applied.
	 */
	private final UINT16 characterId;

	/**
	 * Center region of 9-slice grid
	 */
	private final Rect splitter;

	/**
	 * Creates a new DefineScalingGrid tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID of sprite or button character upon which the scaling grid will be applied.
	 * @param splitter Center region of 9-slice grid
	 */
	public DefineScalingGridTag(final RecordHeader header, final UINT16 characterId, final Rect splitter) {
		super(header);

		this.characterId = characterId;
		this.splitter = splitter;
	}

	/**
	 * Returns the ID of sprite or button character upon which the scaling grid will be applied.
	 * 
	 * @return The ID of sprite or button character upon which the scaling grid will be applied.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the center region of 9-slice grid
	 * 
	 * @return The center region of 9-slice grid
	 */
	public Rect getSplitter() {
		return splitter;
	}
}