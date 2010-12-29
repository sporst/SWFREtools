package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class FilterListParser {

	public static FilterList parse(final BinaryParser parser) {
		final int numberOfFilters = parser.readUInt8();
		final List<Filter> filters = new ArrayList<Filter>();

		for (int i=0;i<numberOfFilters;i++) {
			filters.add(FilterParser.parse(parser));
		}

		return new FilterList(numberOfFilters, filters);
	}
}
