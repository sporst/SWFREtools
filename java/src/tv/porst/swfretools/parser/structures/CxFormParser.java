package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Used to parse CXFORM structures.
 * 
 * @author sp
 */
public final class CxFormParser {

	/**
	 * Parses a CXFORM structure.
	 * 
	 * @param parser Provides the input data.
	 * @param fieldName Name of the CXFORM field that is parsed.
	 * 
	 * @return The parsed CXFORM value.
	 * 
	 * @throws SWFParserException Thrown if parsing the CXFORM value failed.
	 */
	public static CxForm parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

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
		final Bits redAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::RedAddTerm");
		final Bits greenAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::GreenAddTerm");
		final Bits blueAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");

		return new CxForm(hasAddTerms, hasMultTerms, nBits, redMultTerm, greenMultTerm, blueMultTerm, redAddTerm, greenAddTerm, blueAddTerm);
	}
}