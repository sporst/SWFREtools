package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.ActionList;
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

	private final ActionList actions;

	/**
	 * Creates a new DoInitAction tag object.
	 * 
	 * @param header Tag header.
	 * @param spriteId Sprite to which these actions apply.
	 * @param actionList
	 */
	public DoInitActionTag(final RecordHeader header, final UINT16 spriteId, final ActionList actions) {

		super(header);

		this.spriteId = spriteId;
		this.actions = actions;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ActionList getActions() {
		return actions;
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