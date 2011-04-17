package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents an End tag.
 */
public final class EndTag extends Tag {

	/**
	 * Creates a new End tag object.
	 * 
	 * @param header Tag header.
	 */
	public EndTag(final RecordHeader header) {
		super(header);
	}
}