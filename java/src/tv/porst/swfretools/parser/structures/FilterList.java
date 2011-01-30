package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a FilterList structure.
 * 
 * @author sp
 *
 */
public final class FilterList {

	/**
	 * Number of filters.
	 */
	private final UINT8 numberOfFilters;

	/**
	 * List of filters.
	 */
	private final List<Filter> filters;

	/**
	 * Creates a new FilterList object.
	 * 
	 * @param numberOfFilters Number of filters.
	 * @param filters List of filters.
	 */
	public FilterList(final UINT8 numberOfFilters, final List<Filter> filters) {

		this.numberOfFilters = numberOfFilters;
		this.filters = new ArrayList<Filter>(filters);

	}

	/**
	 * Returns the list of filters.
	 *
	 * @return The list of filters.
	 */
	public List<Filter> getFilters() {
		return new ArrayList<Filter>(filters);
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