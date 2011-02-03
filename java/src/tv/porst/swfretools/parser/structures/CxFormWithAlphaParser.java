package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses CxFormWithAlphaParser structures.
 * 
 * @author sp
 */
public final class CxFormWithAlphaParser {

	/**
	 * Parses a CxFormwWithAlpha structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static CxFormWithAlpha parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		if (parser == null) {
			throw new IllegalArgumentException("Parser argument must not be null");
		}

		if (fieldName == null) {
			throw new IllegalArgumentException("Field name argument must not be null");
		}

		final Flag hasAddTerms = parseFlag(parser, 0x00006, fieldName + "::HasAddTerms");
		final Flag hasMultTerms = parseFlag(parser, 0x00006, fieldName + "::HasMultTerms");
		final UBits nBits = parseUBits(parser, 4, 0x00006, fieldName + "::NBits");
		final Bits redMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::RedMultTerm");
		final Bits greenMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::GreenMultTerm");
		final Bits blueMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::BlueMultTerm");
		final Bits alphaMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::BlueMultTerm");
		final Bits redAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::RedAddTerm");
		final Bits greenAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::GreenAddTerm");
		final Bits blueAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");
		final Bits alphaAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");

		parser.align();

		return new CxFormWithAlpha(hasAddTerms, hasMultTerms, nBits, redMultTerm, greenMultTerm, blueMultTerm, alphaMultTerm, redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm);
	}

	/**
	 * Parses a CxFormwWithAlpha structure if a condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true for the structure to be parsed.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static CxFormWithAlpha parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}