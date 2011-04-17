package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a JPEGTables tag.
 */
public final class JPEGTablesTag extends Tag {

	/**
	 * JPEG encoding tables.
	 */
	private final ByteArray jpegData;

	/**
	 * Creates a new JPEGTables tag object.
	 * 
	 * @param header Tag header.
	 * @param jpegData JPEG encoding tables.
	 */
	public JPEGTablesTag(final RecordHeader header, final ByteArray jpegData) {
		super(header);

		this.jpegData = jpegData;
	}

	/**
	 * Returns the JPEG encoding tables.
	 * 
	 * @return The JPEG encoding tables.
	 */
	public ByteArray getJpegData() {
		return jpegData;
	}
}