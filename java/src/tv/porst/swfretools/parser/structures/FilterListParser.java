package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FilterList structures.
 * 
 * @author sp
 */
public final class FilterListParser {

	/**
	 * Parses a FilterList structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FilterList parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 numberOfFilters = parseUINT8(parser, 0x00006, fieldName + "::NumberOfFilters");
		final List<Filter> filters = new ArrayList<Filter>();

		for (int i=0;i<numberOfFilters.value();i++) {
			filters.add(FilterParser.parse(parser, String.format(fieldName + "::Filters[%d]", i)));
		}

		return new FilterList(numberOfFilters, filters);
	}

	/**
	 * Parses a FilterList structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition Condition to be true for the structure to be parsed.
	 * @param fieldName The name of the structure in the parent structure.
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FilterList parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}
