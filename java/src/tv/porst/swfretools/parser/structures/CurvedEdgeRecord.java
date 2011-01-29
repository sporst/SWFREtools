package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

/**
 * Represents a CurvedEdgeRecord structure.
 * 
 * @author sp
 *
 */
public final class CurvedEdgeRecord implements ShapeRecord, Shape3Record {

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
	 * X control point change.
	 */
	private final SBits controlDeltaX;

	/**
	 * Y control point change.
	 */
	private final SBits controlDeltaY;

	/**
	 * X anchor point change.
	 */
	private final SBits anchorDeltaX;

	/**
	 * Y anchor point change.
	 */
	private final SBits anchorDeltaY;

	/**
	 * Creates a new CurvedEdgeRecord object.
	 * 
	 * @param typeFlag Type flag.
	 * @param straightFlag Edge type flag.
	 * @param numBits Number of bits per value.
	 * @param controlDeltaX X control point change.
	 * @param controlDeltaY Y control point change.
	 * @param anchorDeltaX X anchor point change.
	 * @param anchorDeltaY Y anchor point change.
	 */
	public CurvedEdgeRecord(final Flag typeFlag, final Flag straightFlag,
			final Bits numBits, final SBits controlDeltaX, final SBits controlDeltaY,
			final SBits anchorDeltaX, final SBits anchorDeltaY) {

		this.typeFlag = typeFlag;
		this.straightFlag = straightFlag;
		this.numBits = numBits;
		this.controlDeltaX = controlDeltaX;
		this.controlDeltaY = controlDeltaY;
		this.anchorDeltaX = anchorDeltaX;
		this.anchorDeltaY = anchorDeltaY;
	}

	/**
	 * Returns the X anchor point change.
	 *
	 * @return The X anchor point change.
	 */
	public SBits getAnchorDeltaX() {
		return anchorDeltaX;
	}

	/**
	 * Returns the Y anchor point change.
	 *
	 * @return The Y anchor point change.
	 */
	public SBits getAnchorDeltaY() {
		return anchorDeltaY;
	}

	/**
	 * Returns the X control point change.
	 *
	 * @return The X control point change.
	 */
	public SBits getControlDeltaX() {
		return controlDeltaX;
	}

	/**
	 * Returns the Y control point change.
	 *
	 * @return The Y control point change.
	 */
	public SBits getControlDeltaY() {
		return controlDeltaY;
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
}