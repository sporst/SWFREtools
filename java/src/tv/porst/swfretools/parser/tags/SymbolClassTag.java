package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Symbol;

/**
 * Represents a SymbolClass tag.
 * 
 * @author sp
 *
 */
public final class SymbolClassTag extends Tag {

	/**
	 * Number of symbols that will be associated by this tag.
	 */
	private final UINT16 numSymbols;

	/**
	 * List of symbols associated by this tag.
	 */
	private final List<Symbol> symbols;

	/**
	 * Creates a new SymbolClass tag object.
	 * 
	 * @param header Tag header.
	 * @param numSymbols Number of symbols that will be associated by this tag.
	 * @param symbols List of symbols associated by this tag.
	 */
	public SymbolClassTag(final RecordHeader header, final UINT16 numSymbols,
			final List<Symbol> symbols) {

		super(header);

		this.numSymbols = numSymbols;
		this.symbols = new ArrayList<Symbol>(symbols);
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
	public List<Symbol> getSymbols() {
		return symbols;
	}
}