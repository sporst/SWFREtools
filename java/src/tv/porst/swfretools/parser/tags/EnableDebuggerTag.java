package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents an EnableDebugger tag.
 */
public final class EnableDebuggerTag extends Tag {

	/**
	 * MD5-encrypted password.
	 */
	private final AsciiString password;

	/**
	 * Creates a new EnableDebugger tag object.
	 * 
	 * @param header Tag header.
	 * @param password MD5-encrypted password.
	 */
	public EnableDebuggerTag(final RecordHeader header, final AsciiString password) {

		super(header);

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
}