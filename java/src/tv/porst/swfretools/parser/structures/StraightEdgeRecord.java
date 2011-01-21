package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

/**
 * Represents a StraightEdgeRecord structure.
 * 
 * @author sp
 *
 */
public final class StraightEdgeRecord implements ShapeRecord, Shape3Record {

	/**
	 * Type flag.
	 */
	private final Flag typeFlag;

	/**
	 * Edge type flag.
	 */
	private final Flag straightFlag;

	/**
	 * Number of bits per value.
	 */
	private final Bits numBits;

	/**
	 * General line flag.
	 */
	private final Flag generalLineFlag;

	/**
	 * Vertical line flag.
	 */
	private final Flag vertLineFlag;

	/**
	 * X delta.
	 */
	private final SBits deltaX;

	/**
	 * Y delta.
	 */
	private final SBits deltaY;

	/**
	 * Creates a new S-traightEdgeRecord object.
	 * 
	 * @param typeFlag Type flag.
	 * @param straightFlag Edge type flag.
	 * @param numBits Number of bits per value.
	 * @param generalLineFlag General line flag.
	 * @param vertLineFlag Vertical line flag.
	 * @param deltaX X delta.
	 * @param deltaY Y delta.
	 */
	public StraightEdgeRecord(final Flag typeFlag, final Flag straightFlag,
			final Bits numBits, final Flag generalLineFlag, final Flag vertLineFlag,
			final SBits deltaX, final SBits deltaY) {

		this.typeFlag = typeFlag;
		this.straightFlag = straightFlag;
		this.numBits = numBits;
		this.generalLineFlag = generalLineFlag;
		this.vertLineFlag = vertLineFlag;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	/**
	 * Returns the X delta.
	 *
	 * @return The X delta.
	 */
	public SBits getDeltaX() {
		return deltaX;
	}

	/**
	 * Returns the Y delta.
	 *
	 * @return The Y delta.
	 */
	public SBits getDeltaY() {
		return deltaY;
	}

	/**
	 * Returns the general line flag.
	 *
	 * @return The general line flag.
	 */
	public Flag getGeneralLineFlag() {
		return generalLineFlag;
	}

	/**
	 * Returns the number of bits per value.
	 *
	 * @return The number of bits per value.
	 */
	public Bits getNumBits() {
		return numBits;
	}

	/**
	 * Returns the edge type flag.
	 *
	 * @return The edge type flag.
	 */
	public Flag getStraightFlag() {
		return straightFlag;
	}

	/**
	 * Returns the type flag.
	 *
	 * @return The type flag.
	 */
	public Flag getTypeFlag() {
		return typeFlag;
	}

	/**
	 * Returns the vertical line flag.
	 *
	 * @return The vertical line flag.
	 */
	public Flag getVertLineFlag() {
		return vertLineFlag;
	}
}