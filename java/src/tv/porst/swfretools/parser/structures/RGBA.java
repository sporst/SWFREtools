package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents an RGBA structure.
 * 
 * @author sp
 *
 */
public final class RGBA {

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
	 * Alpha value defining opacity.
	 */
	private final UINT8 alpha;

	/**
	 * Creates a new RGBA object.
	 * 
	 * @param red Red color value.
	 * @param green Green color value.
	 * @param blue Blue color value.
	 * @param alpha Alpha value defining opacity.
	 */
	public RGBA(final UINT8 red, final UINT8 green, final UINT8 blue, final UINT8 alpha) {

		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;

	}

	/**
	 * Returns the alpha value defining opacity.
	 *
	 * @return The alpha value defining opacity.
	 */
	public UINT8 getAlpha() {
		return alpha;
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