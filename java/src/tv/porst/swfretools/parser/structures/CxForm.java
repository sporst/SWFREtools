package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

/**
 * Represents a CxFormWith structure.
 * 
 * @author sp
 *
 */
public final class CxForm {

	/**
	 * Has color addition values flag.
	 */
	private final Flag hasAddTerms;

	/**
	 * Has color multiply values flag.
	 */
	private final Flag hasMultTerms;

	/**
	 * Bits in each field.
	 */
	private final Bits nBits;

	/**
	 * Red multiply value.
	 */
	private final SBits redMultTerm;

	/**
	 * Green multiply value.
	 */
	private final SBits greenMultTerm;

	/**
	 * Blue multiply value.
	 */
	private final SBits blueMultTerm;

	/**
	 * Red addition value.
	 */
	private final SBits redAddTerm;

	/**
	 * Green addition value.
	 */
	private final SBits greenAddTerm;

	/**
	 * Blue addition value.
	 */
	private final SBits blueAddTerm;

	/**
	 * Creates a new FocalGradient object.
	 * 
	 * @param hasAddTerms Has color addition values flag.
	 * @param hasMultTerms Has color multiply values flag.
	 * @param nBits Bits in each field.
	 * @param redMultTerm Red multiply value.
	 * @param greenMultTerm Green multiply value.
	 * @param blueMultTerm Blue multiply value.
	 * @param redAddTerm Red addition value.
	 * @param greenAddTerm Green addition value.
	 * @param blueAddTerm Blue addition value.
	 */
	public CxForm(final Flag hasAddTerms, final Flag hasMultTerms, final Bits nBits,
			final SBits redMultTerm, final SBits greenMultTerm, final SBits blueMultTerm,
			final SBits redAddTerm, final SBits greenAddTerm, final SBits blueAddTerm) {

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

	/**
	 * Returns the blue addition value.
	 *
	 * @return The blue addition value.
	 */
	public SBits getBlueAddTerm() {
		return blueAddTerm;
	}

	/**
	 * Returns the blue multiply value.
	 *
	 * @return The blue multiply value.
	 */
	public SBits getBlueMultTerm() {
		return blueMultTerm;
	}

	/**
	 * Returns the green addition value.
	 *
	 * @return The green addition value.
	 */
	public SBits getGreenAddTerm() {
		return greenAddTerm;
	}

	/**
	 * Returns the green multiply value.
	 *
	 * @return The green multiply value.
	 */
	public SBits getGreenMultTerm() {
		return greenMultTerm;
	}

	/**
	 * Returns the has color addition values flag.
	 *
	 * @return The has color addition values flag.
	 */
	public Flag getHasAddTerms() {
		return hasAddTerms;
	}

	/**
	 * Returns the has color multiply values flag.
	 *
	 * @return The has color multiply values flag.
	 */
	public Flag getHasMultTerms() {
		return hasMultTerms;
	}

	/**
	 * Returns the bits in each field.
	 *
	 * @return The bits in each field.
	 */
	public Bits getnBits() {
		return nBits;
	}

	/**
	 * Returns the red addition value.
	 *
	 * @return The red addition value.
	 */
	public SBits getRedAddTerm() {
		return redAddTerm;
	}

	/**
	 * Returns the red multiply value.
	 *
	 * @return The red multiply value.
	 */
	public SBits getRedMultTerm() {
		return redMultTerm;
	}
}