package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;

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
	private final UBits pix15Reserved;

	/**
	 * Red value.
	 */
	private final UBits pix15Red;

	/**
	 * Green value.
	 */
	private final UBits pix15Green;

	/**
	 * Blue value.
	 */
	private final UBits pix15Blue;

	/**
	 * Creates a new Pix15 object.
	 * 
	 * @param pix15Reserved Reserved bits.
	 * @param pix15Red Red value.
	 * @param pix15Green Green value.
	 * @param pix15Blue Blue value.
	 */
	public Pix15(final UBits pix15Reserved, final UBits pix15Red, final UBits pix15Blue, final UBits pix15Green) {

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
	public UBits getPix15Blue() {
		return pix15Blue;
	}

	/**
	 * Returns the green value.
	 *
	 * @return The green value.
	 */
	public UBits getPix15Green() {
		return pix15Green;
	}

	/**
	 * Returns the red value.
	 *
	 * @return The red value.
	 */
	public UBits getPix15Red() {
		return pix15Red;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UBits getPix15Reserved() {
		return pix15Reserved;
	}
}