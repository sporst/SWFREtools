package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class FilterListParser {

	public static FilterList parse(final BinaryParser parser) {
		final UINT8 numberOfFilters = parser.readUInt8();
		final List<Filter> filters = new ArrayList<Filter>();

		for (int i=0;i<numberOfFilters.value();i++) {
			filters.add(FilterParser.parse(parser));
		}

		return new FilterList(numberOfFilters, filters);
	}
}
