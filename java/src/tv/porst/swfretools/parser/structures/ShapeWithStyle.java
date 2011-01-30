package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;

/**
 * Represents a ShapeWithStyle structure.
 * 
 * @author sp
 *
 */
public final class ShapeWithStyle {

	/**
	 * Array of fill styles.
	 */
	private final FillStyleArray fillStyles;

	/**
	 * Array of line styles.
	 */
	private final LineStyleArray lineStyles;

	/**
	 * Number of fill index bits.
	 */
	private final UBits numFillBits;

	/**
	 * Number of line index bits.
	 */
	private final UBits numLineBits;

	/**
	 * Shape records.
	 */
	private final ShapeRecord shapeRecord;

	/**
	 * Creates a new ShapeWithStyle object.
	 * 
	 * @param fillStyles Array of fill styles.
	 * @param lineStyles Array of line styles.
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecord Shape records.
	 */
	public ShapeWithStyle(final FillStyleArray fillStyles, final LineStyleArray lineStyles,
			final UBits numFillBits, final UBits numLineBits, final ShapeRecord shapeRecord) {

		this.fillStyles = fillStyles;
		this.lineStyles = lineStyles;
		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecord = shapeRecord;

	}

	/**
	 * Returns the array of fill styles.
	 *
	 * @return The array of fill styles.
	 */
	public FillStyleArray getFillStyles() {
		return fillStyles;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public LineStyleArray getLineStyles() {
		return lineStyles;
	}

	/**
	 * Returns the number of fill index bits.
	 *
	 * @return The number of fill index bits.
	 */
	public UBits getNumFillBits() {
		return numFillBits;
	}

	/**
	 * Returns the number of line index bits.
	 *
	 * @return The number of line index bits.
	 */
	public UBits getNumLineBits() {
		return numLineBits;
	}

	/**
	 * Returns the shape records.
	 *
	 * @return The shape records.
	 */
	public ShapeRecord getShapeRecord() {
		return shapeRecord;
	}
}