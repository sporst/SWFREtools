package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

/**
 * Represents a CxFormWithAlpha structure.
 * 
 * @author sp
 *
 */
public final class CxFormWithAlpha {

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
	 * Alpha multiply value.
	 */
	private final SBits alphaMultTerm;

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
	 * Alpha addition value.
	 */
	private final SBits alphaAddTerm;

	/**
	 * Creates a new FocalGradient object.
	 * 
	 * @param hasAddTerms Has color addition values flag.
	 * @param hasMultTerms Has color multiply values flag.
	 * @param nBits Bits in each field.
	 * @param redMultTerm Red multiply value.
	 * @param greenMultTerm Green multiply value.
	 * @param blueMultTerm Blue multiply value.
	 * @param alphaMultTerm Alpha multiply value.
	 * @param redAddTerm Red addition value.
	 * @param greenAddTerm Green addition value.
	 * @param blueAddTerm Blue addition value.
	 * @param alphaAddTerm Alpha addition value.
	 */
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

	/**
	 * Returns the alpha addition value.
	 *
	 * @return The alpha addition value.
	 */
	public SBits getAlphaAddTerm() {
		return alphaAddTerm;
	}

	/**
	 * Returns the alpha multiply value.
	 *
	 * @return The alpha multiply value.
	 */
	public SBits getAlphaMultTerm() {
		return alphaMultTerm;
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