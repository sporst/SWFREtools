package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UBits;

/**
 * Represents a Shape3 structure.
 * 
 * @author sp
 *
 */
public final class Shape3 implements IFileElement {

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
	private final Shape3RecordList shapeRecords;

	/**
	 * Creates a new Shape3 object.
	 * 
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecords Shape records.
	 */
	public Shape3(final UBits numFillBits, final UBits numLineBits, final Shape3RecordList shapeRecords) {

		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecords = shapeRecords;

	}

	@Override
	public int getBytePosition() {
		return numFillBits.getBytePosition();
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
	public Shape3RecordList getShapeRecord() {
		return shapeRecords;
	}
}