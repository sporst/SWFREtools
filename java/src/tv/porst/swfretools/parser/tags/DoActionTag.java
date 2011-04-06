package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DoAction tag.
 * 
 * @author sp
 *
 */
public final class DoActionTag extends Tag {

	private final ActionList actions;

	/**
	 * Creates a new DoAction tag object.
	 * 
	 * @param header Tag header.
	 * @param actionList
	 */
	public DoActionTag(final RecordHeader header, final ActionList actions) {
		super(header);

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
}