package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a Shape structure.
 * 
 * @author sp
 *
 */
public final class Shape implements IFileElement {

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
	private final ShapeRecordList shapeRecords;

	/**
	 * Creates a new Shape object.
	 * 
	 * @param numFillBits Number of fill index bits.
	 * @param numLineBits Number of line index bits.
	 * @param shapeRecords Shape records.
	 */
	public Shape(final UBits numFillBits, final UBits numLineBits, final ShapeRecordList shapeRecords) {

		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
		this.shapeRecords = shapeRecords;

	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(numFillBits, numLineBits, shapeRecords);
	}

	@Override
	public int getBitPosition() {
		return numFillBits.getBitPosition();
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
	public ShapeRecordList getShapeRecord() {
		return shapeRecords;
	}
}