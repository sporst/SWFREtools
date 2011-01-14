package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

public class CxFormWithAlpha {

	private final Flag hasAddTerms;
	private final Flag hasMultTerms;
	private final Bits nBits;
	private final SBits redMultTerm;
	private final SBits greenMultTerm;
	private final SBits blueMultTerm;
	private final SBits alphaMultTerm;
	private final SBits redAddTerm;
	private final SBits greenAddTerm;
	private final SBits blueAddTerm;
	private final SBits alphaAddTerm;

	public CxFormWithAlpha(final Flag hasAddTerms, final Flag hasMultTerms, final Bits nBits,
			final SBits redMultTerm, final SBits greenMultTerm, final SBits blueMultTerm,
			final SBits alphaMultTerm, final SBits redAddTerm, final SBits greenAddTerm,
			final SBits blueAddTerm, final SBits alphaAddTerm) {

		this.hasAddTerms = hasAddTerms;
		this.hasMultTerms = hasMultTerms;
		this.nBits = nBits;
		this.redMultTerm = redMultTerm;
		this.greenMultTerm = greenMultTerm;
		this.blueMultTerm = blueMultTerm;
		this.alphaMultTerm = alphaMultTerm;
		this.redAddTerm = redAddTerm;
		this.greenAddTerm = greenAddTerm;
		this.blueAddTerm = blueAddTerm;
		this.alphaAddTerm = alphaAddTerm;
	}

}
