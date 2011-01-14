package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBitsIf;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class CxFormWithAlphaParser {

	public static CxFormWithAlpha parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

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
		final SBits alphaMultTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasMultTerms.value(), fieldName + "::BlueMultTerm");
		final SBits redAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::RedAddTerm");
		final SBits greenAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::GreenAddTerm");
		final SBits blueAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");
		final SBits alphaAddTerm = parseSBitsIf(parser, nBits.value(), 0x00006, hasAddTerms.value(), fieldName + "::BlueAddTerm");

		return new CxFormWithAlpha(hasAddTerms, hasMultTerms, nBits, redMultTerm, greenMultTerm, blueMultTerm, alphaMultTerm, redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm);
	}

	public static CxFormWithAlpha parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}

}
