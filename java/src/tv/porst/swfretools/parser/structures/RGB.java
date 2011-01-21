package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents an RGB structure.
 * 
 * @author sp
 *
 */
public final class RGB {

	/**
	 * Red color value.
	 */
	private final UINT8 red;

	/**
	 * Green color value.
	 */
	private final UINT8 green;

	/**
	 * Blue color value.
	 */
	private final UINT8 blue;

	/**
	 * Creates a new RGB object.
	 * 
	 * @param red Red color value.
	 * @param green Green color value.
	 * @param blue Blue color value.
	 */
	public RGB(final UINT8 red, final UINT8 green, final UINT8 blue) {

		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/**
	 * Returns the blue color value.
	 *
	 * @return The blue color value.
	 */
	public UINT8 getBlue() {
		return blue;
	}

	/**
	 * Returns the green color value.
	 *
	 * @return The green color value.
	 */
	public UINT8 getGreen() {
		return green;
	}

	/**
	 * Returns the red color value.
	 *
	 * @return The red color value.
	 */
	public UINT8 getRed() {
		return red;
	}
}