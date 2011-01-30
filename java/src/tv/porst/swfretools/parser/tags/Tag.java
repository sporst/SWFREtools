package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Base class of all concrete SWF tags.
 * 
 * @author sp
 *
 */
public abstract class Tag {

	/**
	 * The tag header.
	 */
	private final RecordHeader header;

	/**
	 * Creates a new tag object.
	 * 
	 * @param header The tag header.
	 */
	public Tag(final RecordHeader header) {

		this.header = header;
	}

	/**
	 * Returns the tag header.
	 * 
	 * @return The tag header.
	 */
	public RecordHeader getHeader() {
		return header;
	}
}