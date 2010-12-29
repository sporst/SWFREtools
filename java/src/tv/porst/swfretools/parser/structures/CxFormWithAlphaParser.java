package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class CxFormWithAlphaParser {

	public static CxFormWithAlpha parse(final BinaryParser parser) {

		final int hasAddTerms = parser.readBits(1);
		final int hasMultTerms = parser.readBits(1);
		final int nBits = parser.readBits(4);

		final int redMultTerm = hasMultTerms == 1 ? parser.readSBits(nBits) : 0;
		final int greenMultTerm = hasMultTerms == 1 ? parser.readSBits(nBits) : 0;
		final int blueMultTerm = hasMultTerms == 1 ? parser.readSBits(nBits) : 0;
		final int alphaMultTerm = hasMultTerms == 1 ? parser.readSBits(nBits) : 0;

		final int redAddTerm = hasAddTerms == 1 ? parser.readSBits(nBits) : 0;
		final int greenAddTerm = hasAddTerms == 1 ? parser.readSBits(nBits) : 0;
		final int blueAddTerm = hasAddTerms == 1 ? parser.readSBits(nBits) : 0;
		final int alphaAddTerm = hasAddTerms == 1 ? parser.readSBits(nBits) : 0;

		return new CxFormWithAlpha(hasAddTerms, hasMultTerms, nBits, redMultTerm, greenMultTerm, blueMultTerm, alphaMultTerm, redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm);
	}

}
