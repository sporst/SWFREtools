package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SymbolList;

/**
 * Represents a SymbolClass tag.
 */
public final class SymbolClassTag extends Tag {

	/**
	 * Number of symbols that will be associated by this tag.
	 */
	private final UINT16 numSymbols;

	/**
	 * List of symbols associated by this tag.
	 */
	private final SymbolList symbols;

	/**
	 * Creates a new SymbolClass tag object.
	 * 
	 * @param header Tag header.
	 * @param numSymbols Number of symbols that will be associated by this tag.
	 * @param symbols List of symbols associated by this tag.
	 */
	public SymbolClassTag(final RecordHeader header, final UINT16 numSymbols,
			final SymbolList symbols) {

		super(header);

		this.numSymbols = numSymbols;
		this.symbols = symbols;
	}

	/**
	 * Returns the number of symbols that will be associated by this tag.
	 * 
	 * @return The number of symbols that will be associated by this tag.
	 */
	public UINT16 getNumSymbols() {
		return numSymbols;
	}

	/**
	 * Returns the list of symbols associated by this tag.
	 * 
	 * @return The list of symbols associated by this tag.
	 */
	public SymbolList getSymbols() {
		return symbols;
	}
}