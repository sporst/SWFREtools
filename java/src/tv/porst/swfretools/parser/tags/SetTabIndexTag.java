package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a SetTabIndex tag.
 */
public final class SetTabIndexTag extends Tag {

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * Tab order value.
	 */
	private final UINT16 tabIndex;

	/**
	 * Creates a new SetTabIndex tag object.
	 * 
	 * @param header Tag header.
	 * @param depth Depth of character.
	 * @param tabIndex Tab order value.
	 */
	public SetTabIndexTag(final RecordHeader header, final UINT16 depth, final UINT16 tabIndex) {
		super(header);

		SWFParserHelpers.checkNull(depth, "Depth");
		SWFParserHelpers.checkNull(tabIndex, "TabIndex");

		this.depth = depth;
		this.tabIndex = tabIndex;
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
	 * Returns the tab order value.
	 * 
	 * @return The tab order value.
	 */
	public UINT16 getTabIndex() {
		return tabIndex;
	}
}
