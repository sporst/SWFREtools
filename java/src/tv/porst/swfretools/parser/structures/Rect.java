package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Bits;

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
	private final UBits nBits;

	/**
	 * X minimum position for rectangle in twips.
	 */
	private final Bits xMin;

	/**
	 * X maximum position for rectangle in twips.
	 */
	private final Bits xMax;

	/**
	 * Y minimum position for rectangle in twips.
	 */
	private final Bits yMin;

	/**
	 * Y maximum position for rectangle in twips.
	 */
	private final Bits yMax;

	/**
	 * Creates a new Rect object.
	 * 
	 * @param nBits Bits used for each subsequent field.
	 * @param xMin X minimum position for rectangle in twips.
	 * @param xMax X maximum position for rectangle in twips.
	 * @param yMin Y minimum position for rectangle in twips.
	 * @param yMax Y maximum position for rectangle in twips.
	 */
	public Rect(final UBits nBits, final Bits xMin, final Bits xMax, final Bits yMin, final Bits yMax) {

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
	public UBits getnBits() {
		return nBits;
	}

	/**
	 * Returns the X maximum position for rectangle in twips.
	 *
	 * @return The X maximum position for rectangle in twips.
	 */
	public Bits getxMax() {
		return xMax;
	}

	/**
	 * Returns the X minimum position for rectangle in twips.
	 *
	 * @return The X minimum position for rectangle in twips.
	 */
	public Bits getxMin() {
		return xMin;
	}

	/**
	 * Returns the Y maximum position for rectangle in twips.
	 *
	 * @return The Y maximum position for rectangle in twips.
	 */
	public Bits getyMax() {
		return yMax;
	}

	/**
	 * Returns the Y minimum position for rectangle in twips.
	 *
	 * @return The Y minimum position for rectangle in twips.
	 */
	public Bits getyMin() {
		return yMin;
	}
}