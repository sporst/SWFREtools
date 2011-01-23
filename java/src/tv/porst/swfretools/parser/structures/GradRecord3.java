package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents a GradRecord3 structure.
 * 
 * @author sp
 *
 */
public final class GradRecord3 {

	/**
	 * Ratio value.
	 */
	private final UINT8 ratio;

	/**
	 * Color of gradient.
	 */
	private final RGBA color;

	/**
	 * Creates a new GradRecord3 object.
	 * 
	 * @param ratio Ratio value.
	 * @param color Color of gradient.
	 */
	public GradRecord3(final UINT8 ratio, final RGBA color) {

		this.ratio = ratio;
		this.color = color;
	}

	/**
	 * Returns the color of gradient.
	 *
	 * @return The color of gradient.
	 */
	public RGBA getColor() {
		return color;
	}

	/**
	 * Returns the ratio value.
	 *
	 * @return The ratio value.
	 */
	public UINT8 getRatio() {
		return ratio;
	}
}