package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DoAction tag.
 */
public final class DoActionTag extends Tag {

	/**
	 * Actions that are associated with this tag.
	 */
	private final ActionList actions;

	/**
	 * Creates a new DoAction tag object.
	 * 
	 * @param header Tag header.
	 * @param actions Actions that are associated with this tag.
	 */
	public DoActionTag(final RecordHeader header, final ActionList actions) {
		super(header);

		this.actions = actions;
	}

	/**
	 * Returns the actions that are associated with this tag.
	 *
	 * @return The actions that are associated with this tag.
	 */
	public ActionList getActions() {
		return actions;
	}
}