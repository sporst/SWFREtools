package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a StartSound2 tag.
 * 
 * @author sp
 *
 */
public class ProtectTag extends Tag {

	/**
	 * MD5 of the password required to modify the document. This value can be null.
	 */
	private final ByteArray data;

	/**
	 * Creates a new Protect tag object.
	 * 
	 * @param header Tag header.
	 * @param data MD5 of the password required to modify the document. This value can be null.
	 */
	public ProtectTag(final RecordHeader header, final ByteArray data) {
		super(header);

		this.data = data;
	}

	/**
	 * Returns the MD5 of the password required to modify the document. This value can be null.
	 * 
	 * @return The MD5 of the password required to modify the document. This value can be null.
	 */
	public ByteArray getData() {
		return data;
	}
}