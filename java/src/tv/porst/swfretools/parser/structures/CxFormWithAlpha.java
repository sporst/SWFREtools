package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

public class CxFormWithAlpha {

	private final Flag hasAddTerms;
	private final Flag hasMultTerms;
	private final int nBits;
	private final SBits redMultTerm;
	private final SBits greenMultTerm;
	private final SBits blueMultTerm;
	private final SBits alphaMultTerm;
	private final SBits redAddTerm;
	private final SBits greenAddTerm;
	private final SBits blueAddTerm;
	private final SBits alphaAddTerm;

	public CxFormWithAlpha(final Flag hasAddTerms2, final Flag hasMultTerms2, final int nBits,
			final SBits redMultTerm2, final SBits greenMultTerm2, final SBits blueMultTerm2,
			final SBits alphaMultTerm2, final SBits redAddTerm2, final SBits greenAddTerm2,
			final SBits blueAddTerm2, final SBits alphaAddTerm2) {

		this.hasAddTerms = hasAddTerms2;
		this.hasMultTerms = hasMultTerms2;
		this.nBits = nBits;
		this.redMultTerm = redMultTerm2;
		this.greenMultTerm = greenMultTerm2;
		this.blueMultTerm = blueMultTerm2;
		this.alphaMultTerm = alphaMultTerm2;
		this.redAddTerm = redAddTerm2;
		this.greenAddTerm = greenAddTerm2;
		this.blueAddTerm = blueAddTerm2;
		this.alphaAddTerm = alphaAddTerm2;
	}

}
