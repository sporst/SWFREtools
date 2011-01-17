package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a ShowFrame tag.
 * 
 * @author sp
 *
 */
public class ShowFrameTag extends Tag {

	/**
	 * Creates a new ShowFrame tag object.
	 * 
	 * @param header Tag header.
	 */
	public ShowFrameTag(final RecordHeader header) {
		super(header);
	}
}