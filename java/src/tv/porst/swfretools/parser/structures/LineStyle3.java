package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents a LineStyle3 structure.
 * 
 * @author sp
 *
 */
public final class LineStyle3 {

	/**
	 * Width of line in twips.
	 */
	private final UINT8 width;

	/**
	 * Color value including alpha channel.
	 */
	private final RGBA color;

	/**
	 * Creates a new LineStyle3 object.
	 * 
	 * @param width Width of line in twips.
	 * @param color Color value including alpha channel.
	 */
	public LineStyle3(final UINT8 width, final RGBA color) {

		this.width = width;
		this.color = color;
	}

	/**
	 * Returns the color value including alpha channel.
	 *
	 * @return The color value including alpha channel.
	 */
	public RGBA getColor() {
		return color;
	}

	/**
	 * Returns the width of line in twips.
	 *
	 * @return The width of line in twips.
	 */
	public UINT8 getWidth() {
		return width;
	}
}