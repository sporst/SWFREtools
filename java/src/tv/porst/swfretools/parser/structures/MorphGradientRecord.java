package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents a MorphGradientRecord structure.
 * 
 * @author sp
 *
 */
public final class MorphGradientRecord {

	/**
	 * Ratio value for start shape.
	 */
	private final UINT8 startRatio;

	/**
	 * Color of gradient for start shape.
	 */
	private final RGBA startColor;

	/**
	 * Ratio value for end shape.
	 */
	private final UINT8 endRatio;

	/**
	 * Color of gradient for end shape.
	 */
	private final RGBA endColor;

	/**
	 * Creates a new MorphGradientRecord object.
	 * 
	 * @param startRatio Ratio value for start shape.
	 * @param startColor Color of gradient for start shape.
	 * @param endRatio Ratio value for end shape.
	 * @param endColor Color of gradient for end shape.
	 */
	public MorphGradientRecord(final UINT8 startRatio, final RGBA startColor, final UINT8 endRatio,
			final RGBA endColor) {

		this.startRatio = startRatio;
		this.startColor = startColor;
		this.endRatio = endRatio;
		this.endColor = endColor;
	}

	/**
	 * Returns the color of gradient for end shape.
	 *
	 * @return The color of gradient for end shape.
	 */
	public RGBA getEndColor() {
		return endColor;
	}

	/**
	 * Returns the ratio value for end shape.
	 *
	 * @return The ratio value for end shape.
	 */
	public UINT8 getEndRatio() {
		return endRatio;
	}

	/**
	 * Returns the color of gradient for start shape.
	 *
	 * @return The color of gradient for start shape.
	 */
	public RGBA getStartColor() {
		return startColor;
	}

	/**
	 * Returns the ratio value for start shape.
	 *
	 * @return The ratio value for start shape.
	 */
	public UINT8 getStartRatio() {
		return startRatio;
	}
}