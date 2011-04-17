package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBinaryData tag.
 */
public final class DefineBinaryDataTag extends Tag {

	/**
	 * 16-bit character ID.
	 */
	private final UINT16 tag;

	/**
	 * Reserved space.
	 */
	private final UINT32 reserved;

	/**
	 * A blob of binary data.
	 */
	private final ByteArray data;

	/**
	 * Creates a new DefineBinaryData tag object.
	 * 
	 * @param header Tag header.
	 * @param tag 16-bit character ID.
	 * @param reserved Reserved space.
	 * @param data A blob of binary data.
	 */
	public DefineBinaryDataTag(final RecordHeader header, final UINT16 tag, final UINT32 reserved, final ByteArray data) {
		super(header);

		this.tag = tag;
		this.reserved = reserved;
		this.data = data;
	}

	/**
	 * Returns a blob of binary data.
	 * 
	 * @return A blob of binary data.
	 */
	public ByteArray getData() {
		return data;
	}

	/**
	 * Returns the reserved space.
	 * 
	 * @return The reserved space.
	 */
	public UINT32 getReserved() {
		return reserved;
	}

	/**
	 * Returns the 16-bit character ID.
	 * 
	 * @return The 16-bit character ID.
	 */
	public UINT16 getTag() {
		return tag;
	}
}