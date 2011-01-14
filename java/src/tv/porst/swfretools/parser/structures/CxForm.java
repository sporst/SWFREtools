package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

public class CxForm {

	private final Flag hasAddTerms;
	private final Flag hasMultTerms;
	private final Bits nBits;
	private final SBits redMultTerm;
	private final SBits greenMultTerm;
	private final SBits blueMultTerm;
	private final SBits redAddTerm;
	private final SBits greenAddTerm;
	private final SBits blueAddTerm;

	public CxForm(final Flag hasAddTerms2, final Flag hasMultTerms2, final Bits nBits,
			final SBits redMultTerm2, final SBits greenMultTerm2, final SBits blueMultTerm2,
			final SBits redAddTerm2, final SBits greenAddTerm2, final SBits blueAddTerm2) {

		this.hasAddTerms = hasAddTerms2;
		this.hasMultTerms = hasMultTerms2;
		this.nBits = nBits;
		this.redMultTerm = redMultTerm2;
		this.greenMultTerm = greenMultTerm2;
		this.blueMultTerm = blueMultTerm2;
		this.redAddTerm = redAddTerm2;
		this.greenAddTerm = greenAddTerm2;
		this.blueAddTerm = blueAddTerm2;
	}

}
