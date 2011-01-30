package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Float32;

/**
 * Represents a ColorMatrixFilter structure.
 * 
 * @author sp
 *
 */
public final class ColorMatrixFilter {

	/**
	 * Color matrix values.
	 */
	private final Float32[] matrix;

	/**
	 * Creates a new ColorMatrixFilter object.
	 * 
	 * @param matrix Color matrix values.
	 */
	public ColorMatrixFilter(final Float32[] matrix) {

		this.matrix = matrix == null ? matrix : matrix.clone();
	}

	/**
	 * Returns the color matrix values.
	 *
	 * @return The color matrix values.
	 */
	public Float32[] getMatrix() {
		return matrix == null ? matrix : matrix.clone();
	}
}