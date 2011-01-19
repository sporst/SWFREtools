package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;

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
	private final PString name;

	/**
	 * Creates a new Symbol object.
	 * 
	 * @param tag Character ID.
	 * @param name Symbol identifier.
	 */
	public Symbol(final UINT16 tag, final PString name) {

		this.tag = tag;
		this.name = name;

	}

	/**
	 * Returns the symbol identifier.
	 *
	 * @return The symbol identifier.
	 */
	public PString getName() {
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