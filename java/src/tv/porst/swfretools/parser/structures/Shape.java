package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

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
	private final ArrayList<ShapeRecord> shapeRecords;

	/**
	 * Creates a new Shape object.
	 * 
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecords Shape records.
	 */
	public Shape(final UBits numFillBits, final UBits numLineBits, final List<ShapeRecord> shapeRecords) {

		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecords = new ArrayList<ShapeRecord>(shapeRecords);

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
	public ArrayList<ShapeRecord> getShapeRecord() {
		return new ArrayList<ShapeRecord>(shapeRecords);
	}
}