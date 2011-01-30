package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;

/**
 * Represents a Shape structure.
 * 
 * @author sp
 *
 */
public final class Shape {

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
	 * Creates a new Shape object.
	 * 
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecord Shape records.
	 */
	public Shape(final UBits numFillBits, final UBits numLineBits, final ShapeRecord shapeRecord) {

		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecord = shapeRecord;

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