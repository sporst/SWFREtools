package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;

/**
 * Represents a Symbol structure.
 * 
 * @author sp
 *
 */
public final class Symbol {

	/**
	 * Character ID.
	 */
	private final UINT16 tag;

	/**
	 * Symbol identifier.
	 */
	private final AsciiString name;

	/**
	 * Creates a new Symbol object.
	 * 
	 * @param tag Character ID.
	 * @param name Symbol identifier.
	 */
	public Symbol(final UINT16 tag, final AsciiString name) {

		this.tag = tag;
		this.name = name;

	}

	/**
	 * Returns the symbol identifier.
	 *
	 * @return The symbol identifier.
	 */
	public AsciiString getName() {
		return name;
	}

	/**
	 * Returns the character ID.
	 *
	 * @return The character ID.
	 */
	public UINT16 getTag() {
		return tag;
	}
}