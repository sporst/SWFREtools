package tv.porst.swfretools.parser.structures;

public class CxForm {

	private final int hasAddTerms;
	private final int hasMultTerms;
	private final int nBits;
	private final int redMultTerm;
	private final int greenMultTerm;
	private final int blueMultTerm;
	private final int redAddTerm;
	private final int greenAddTerm;
	private final int blueAddTerm;

	public CxForm(final int hasAddTerms, final int hasMultTerms, final int nBits,
			final int redMultTerm, final int greenMultTerm, final int blueMultTerm,
			final int redAddTerm, final int greenAddTerm, final int blueAddTerm) {

		this.hasAddTerms = hasAddTerms;
		this.hasMultTerms = hasMultTerms;
		this.nBits = nBits;
		this.redMultTerm = redMultTerm;
		this.greenMultTerm = greenMultTerm;
		this.blueMultTerm = blueMultTerm;
		this.redAddTerm = redAddTerm;
		this.greenAddTerm = greenAddTerm;
		this.blueAddTerm = blueAddTerm;
	}

}
