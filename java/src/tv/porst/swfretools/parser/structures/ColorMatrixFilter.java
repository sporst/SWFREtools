package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a ColorMatrixFilter structure.
 * 
 * @author sp
 *
 */
public final class ColorMatrixFilter implements IFileElement {

	/**
	 * Color matrix values.
	 */
	private final Float32List matrix;

	/**
	 * Creates a new ColorMatrixFilter object.
	 * 
	 * @param matrix Color matrix values.
	 */
	public ColorMatrixFilter(final Float32List matrix) {

		this.matrix = matrix;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(matrix);
	}

	@Override
	public int getBitPosition() {
		return matrix.getBitPosition();
	}

	/**
	 * Returns the color matrix values.
	 *
	 * @return The color matrix values.
	 */
	public Float32List getMatrix() {
		return matrix;
	}
}