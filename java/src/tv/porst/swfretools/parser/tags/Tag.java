package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFParserHelpers;
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
	private RecordHeader header;

	/**
	 * Creates a new tag object.
	 * 
	 * @param header The tag header.
	 */
	public Tag(final RecordHeader header) {

		SWFParserHelpers.checkNull(header, "Header");
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

	/**
	 * Changes the tag header.
	 * 
	 * @param header The new tag header.
	 */
	public void setHeader(final RecordHeader header) {

		SWFParserHelpers.checkNull(header, "Header");
		this.header = header;
	}
}