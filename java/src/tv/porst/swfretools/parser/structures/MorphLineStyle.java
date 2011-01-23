package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT16;

/**
 * Represents a MorphLineStyle structure.
 * 
 * @author sp
 *
 */
public final class MorphLineStyle {

	/**
	 * Width of line in start shape in twips.
	 */
	private final UINT16 startWidth;

	/**
	 * Width of line in end shape in twips.
	 */
	private final UINT16 endWidth;

	/**
	 * Color value of start shape.
	 */
	private final RGBA startColor;

	/**
	 * Color value of end shape.
	 */
	private final RGBA endColor;

	/**
	 * Creates a new MorphLineStyle2 object.
	 * 
	 * @param startWidth Width of line in start shape in twips.
	 * @param endWidth Width of line in end shape in twips.
	 * @param startColor Color value of start shape.
	 * @param endColor Color value of end shape.
	 */
	public MorphLineStyle(final UINT16 startWidth, final UINT16 endWidth, final RGBA startColor, final RGBA endColor) {

		this.startWidth = startWidth;
		this.endWidth = endWidth;
		this.startColor = startColor;
		this.endColor = endColor;

	}

	/**
	 * Returns the color value of end shape.
	 *
	 * @return The color value of end shape.
	 */
	public RGBA getEndColor() {
		return endColor;
	}

	/**
	 * Returns the width of line in end shape in twips.
	 *
	 * @return The width of line in end shape in twips.
	 */
	public UINT16 getEndWidth() {
		return endWidth;
	}

	/**
	 * Returns the color value of start shape.
	 *
	 * @return The color value of start shape.
	 */
	public RGBA getStartColor() {
		return startColor;
	}

	/**
	 * Returns the width of line in start shape in twips.
	 *
	 * @return The width of line in start shape in twips.
	 */
	public UINT16 getStartWidth() {
		return startWidth;
	}
}