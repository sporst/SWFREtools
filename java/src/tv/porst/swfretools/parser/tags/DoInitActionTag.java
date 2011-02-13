package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DoInitAction tag.
 * 
 * @author sp
 *
 */
public final class DoInitActionTag extends Tag {

	/**
	 * Sprite to which these actions apply.
	 */
	private final UINT16 spriteId;

	/**
	 * Creates a new DoInitAction tag object.
	 * 
	 * @param header Tag header.
	 * @param spriteId Sprite to which these actions apply.
	 */
	public DoInitActionTag(final RecordHeader header, final UINT16 spriteId) {

		super(header);

		this.spriteId = spriteId;
	}

	/**
	 * Returns the sprite to which these actions apply.
	 *
	 * @return The sprite to which these actions apply.
	 */
	public UINT16 getSpriteId() {
		return spriteId;
	}
}