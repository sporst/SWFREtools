package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.SBits;

/**
 * Represents a Rectangle structure.
 * 
 * @author sp
 *
 */
public final class Rect {

	/**
	 * Bits used for each subsequent field.
	 */
	private final Bits nBits;

	/**
	 * X minimum position for rectangle in twips.
	 */
	private final SBits xMin;

	/**
	 * X maximum position for rectangle in twips.
	 */
	private final SBits xMax;

	/**
	 * Y minimum position for rectangle in twips.
	 */
	private final SBits yMin;

	/**
	 * Y maximum position for rectangle in twips.
	 */
	private final SBits yMax;

	/**
	 * Creates a new Rect object.
	 * 
	 * @param nBits Bits used for each subsequent field.
	 * @param xMin X minimum position for rectangle in twips.
	 * @param xMax X maximum position for rectangle in twips.
	 * @param yMin Y minimum position for rectangle in twips.
	 * @param yMax Y maximum position for rectangle in twips.
	 */
	public Rect(final Bits nBits, final SBits xMin, final SBits xMax, final SBits yMin, final SBits yMax) {

		this.nBits = nBits;
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;

	}

	/**
	 * Returns the bits used for each subsequent field.
	 *
	 * @return The bits used for each subsequent field.
	 */
	public Bits getnBits() {
		return nBits;
	}

	/**
	 * Returns the X maximum position for rectangle in twips.
	 *
	 * @return The X maximum position for rectangle in twips.
	 */
	public SBits getxMax() {
		return xMax;
	}

	/**
	 * Returns the X minimum position for rectangle in twips.
	 *
	 * @return The X minimum position for rectangle in twips.
	 */
	public SBits getxMin() {
		return xMin;
	}

	/**
	 * Returns the Y maximum position for rectangle in twips.
	 *
	 * @return The Y maximum position for rectangle in twips.
	 */
	public SBits getyMax() {
		return yMax;
	}

	/**
	 * Returns the Y minimum position for rectangle in twips.
	 *
	 * @return The Y minimum position for rectangle in twips.
	 */
	public SBits getyMin() {
		return yMin;
	}
}