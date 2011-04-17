package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents an EnableDebugger2 tag.
 */
public final class EnableDebugger2Tag extends Tag {

	/**
	 * MD5-encrypted password.
	 */
	private final AsciiString password;

	/**
	 * Reserved word.
	 */
	private final UINT16 reserved;

	/**
	 * Creates a new EnableDebugger tag object.
	 * 
	 * @param header Tag header.
	 * @param reserved Reserved word.
	 * @param password MD5-encrypted password.
	 */
	public EnableDebugger2Tag(final RecordHeader header, final UINT16 reserved, final AsciiString password) {
		super(header);

		this.reserved = reserved;
		this.password = password;
	}

	/**
	 * Returns the MD5-encrypted password.
	 * 
	 * @return The MD5-encrypted password.
	 */
	public AsciiString getPassword() {
		return password;
	}

	/**
	 * Returns the reserved word.
	 * 
	 * @return The reserved word.
	 */
	public UINT16 getReserved() {
		return reserved;
	}
}