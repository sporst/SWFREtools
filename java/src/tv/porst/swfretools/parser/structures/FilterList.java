package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FilterList structure.
 * 
 * @author sp
 *
 */
public final class FilterList implements IFileElement {

	/**
	 * Number of filters.
	 */
	private final UINT8 numberOfFilters;

	/**
	 * List of filters.
	 */
	private final SingleFilterList filters;

	/**
	 * Creates a new FilterList object.
	 * 
	 * @param numberOfFilters Number of filters.
	 * @param filters List of filters.
	 */
	public FilterList(final UINT8 numberOfFilters, final SingleFilterList filters) {

		this.numberOfFilters = numberOfFilters;
		this.filters = filters;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(numberOfFilters, filters);
	}

	@Override
	public int getBitPosition() {
		return numberOfFilters.getBitPosition();
	}

	/**
	 * Returns the list of filters.
	 *
	 * @return The list of filters.
	 */
	public SingleFilterList getFilters() {
		return filters;
	}

	/**
	 * Returns the number of filters.
	 *
	 * @return The number of filters.
	 */
	public UINT8 getNumberOfFilters() {
		return numberOfFilters;
	}
}