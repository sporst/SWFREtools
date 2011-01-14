package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;
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
		final Bits nBits = parseBits(parser, 4, 0x00006, fieldName + "::NBits");
		final SBits redMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::RedMultTerm");
		final SBits greenMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::GreenMultTerm");
		final SBits blueMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::BlueMultTerm");
		final SBits redAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::RedAddTerm");
		final SBits greenAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::GreenAddTerm");
		final SBits blueAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");

		return new CxForm(hasAddTerms, hasMultTerms, nBits, redMultTerm, greenMultTerm, blueMultTerm, redAddTerm, greenAddTerm, blueAddTerm);
	}

}
