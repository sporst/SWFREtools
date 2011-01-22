package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;

/**
 * Represents a Pix15 structure.
 * 
 * @author sp
 *
 */
public final class Pix15 {

	/**
	 * Reserved bits.
	 */
	private final Bits pix15Reserved;

	/**
	 * Red value.
	 */
	private final Bits pix15Red;

	/**
	 * Green value.
	 */
	private final Bits pix15Green;

	/**
	 * Blue value.
	 */
	private final Bits pix15Blue;

	/**
	 * Creates a new Pix15 object.
	 * 
	 * @param pix15Reserved Reserved bits.
	 * @param pix15Red Red value.
	 * @param pix15Green Green value.
	 * @param pix15Blue Blue value.
	 */
	public Pix15(final Bits pix15Reserved, final Bits pix15Red, final Bits pix15Blue, final Bits pix15Green) {

		this.pix15Reserved = pix15Reserved;
		this.pix15Red = pix15Red;
		this.pix15Green = pix15Green;
		this.pix15Blue = pix15Blue;

	}

	/**
	 * Returns the blue value.
	 *
	 * @return The blue value.
	 */
	public Bits getPix15Blue() {
		return pix15Blue;
	}

	/**
	 * Returns the green value.
	 *
	 * @return The green value.
	 */
	public Bits getPix15Green() {
		return pix15Green;
	}

	/**
	 * Returns the red value.
	 *
	 * @return The red value.
	 */
	public Bits getPix15Red() {
		return pix15Red;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public Bits getPix15Reserved() {
		return pix15Reserved;
	}
}