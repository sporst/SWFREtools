package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents a Pix24 structure.
 * 
 * @author sp
 *
 */
public final class Pix24 {

	/**
	 * Reserved bits.
	 */
	private final UINT8 pix24Reserved;

	/**
	 * Red value.
	 */
	private final UINT8 pix24Red;

	/**
	 * Green value.
	 */
	private final UINT8 pix24Green;

	/**
	 * Blue value.
	 */
	private final UINT8 pix24Blue;

	/**
	 * Creates a new Pix24 object.
	 * 
	 * @param pix24Reserved Reserved bits.
	 * @param pix24Red Red value.
	 * @param pix24Green Green value.
	 * @param pix24Blue Blue value.
	 */
	public Pix24(final UINT8 pix24Reserved, final UINT8 pix24Red, final UINT8 pix24Green, final UINT8 pix24Blue) {

		this.pix24Reserved = pix24Reserved;
		this.pix24Red = pix24Red;
		this.pix24Green = pix24Green;
		this.pix24Blue = pix24Blue;

	}

	/**
	 * Returns the blue value.
	 *
	 * @return The blue value.
	 */
	public UINT8 getPix24Blue() {
		return pix24Blue;
	}

	/**
	 * Returns the green value.
	 *
	 * @return The green value.
	 */
	public UINT8 getPix24Green() {
		return pix24Green;
	}

	/**
	 * Returns the red value.
	 *
	 * @return The red value.
	 */
	public UINT8 getPix24Red() {
		return pix24Red;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UINT8 getPix24Reserved() {
		return pix24Reserved;
	}
}
