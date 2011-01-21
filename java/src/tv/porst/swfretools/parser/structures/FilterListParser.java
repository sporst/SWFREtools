package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class FilterListParser {

	public static FilterList parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 numberOfFilters = parser.readUInt8();
		final List<Filter> filters = new ArrayList<Filter>();

		for (int i=0;i<numberOfFilters.value();i++) {
			filters.add(FilterParser.parse(parser, String.format(fieldName + "::Filters[%d]", i)));
		}

		return new FilterList(numberOfFilters, filters);
	}

	public static FilterList parseIf(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}
