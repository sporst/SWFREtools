package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses RGB structures.
 * 
 * @author sp
 *
 */
public final class RGBParser {

	/**
	 * Parses an RGB structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static RGB parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 red = parseUINT8(parser, 0x00006, fieldName + "::Red");
		final UINT8 green = parseUINT8(parser, 0x00006, fieldName + "::Green");
		final UINT8 blue = parseUINT8(parser, 0x00006, fieldName + "::Blue");

		return new RGB(red, green, blue);
	}

	/**
	 * Parses an RGB structure if the passed condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition Condition to be evaluated before parsing.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition is false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static RGB parseIf(final SWFBinaryParser parser, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, fieldName) : null;
	}

	/**
	 * Parses an RGB structure if the passed condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition Condition to be evaluated before parsing.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition is false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static RGB parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}