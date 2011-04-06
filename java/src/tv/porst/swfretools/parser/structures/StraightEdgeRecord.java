package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a StraightEdgeRecord structure.
 * 
 * @author sp
 *
 */
public final class StraightEdgeRecord implements ShapeRecord, Shape3Record, Shape4Record {

	/**
	 * Type flag.
	 */
	private final Flag typeFlag;

	/**
	 * Edge type flag.
	 */
	private final Flag straightFlag;

	/**
	 * Number of bits per value.
	 */
	private final UBits numBits;

	/**
	 * General line flag.
	 */
	private final Flag generalLineFlag;

	/**
	 * Vertical line flag.
	 */
	private final Flag vertLineFlag;

	/**
	 * X delta.
	 */
	private final Bits deltaX;

	/**
	 * Y delta.
	 */
	private final Bits deltaY;

	/**
	 * Creates a new S-traightEdgeRecord object.
	 * 
	 * @param typeFlag Type flag.
	 * @param straightFlag Edge type flag.
	 * @param numBits Number of bits per value.
	 * @param generalLineFlag General line flag.
	 * @param vertLineFlag Vertical line flag.
	 * @param deltaX X delta.
	 * @param deltaY Y delta.
	 */
	public StraightEdgeRecord(final Flag typeFlag, final Flag straightFlag,
			final UBits numBits, final Flag generalLineFlag, final Flag vertLineFlag,
			final Bits deltaX, final Bits deltaY) {

		this.typeFlag = typeFlag;
		this.straightFlag = straightFlag;
		this.numBits = numBits;
		this.generalLineFlag = generalLineFlag;
		this.vertLineFlag = vertLineFlag;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(typeFlag, straightFlag, numBits, generalLineFlag,
				vertLineFlag, deltaX, deltaY);
	}

	@Override
	public int getBitPosition() {
		return typeFlag.getBitPosition();
	}

	/**
	 * Returns the X delta.
	 *
	 * @return The X delta.
	 */
	public Bits getDeltaX() {
		return deltaX;
	}

	/**
	 * Returns the Y delta.
	 *
	 * @return The Y delta.
	 */
	public Bits getDeltaY() {
		return deltaY;
	}

	/**
	 * Returns the general line flag.
	 *
	 * @return The general line flag.
	 */
	public Flag getGeneralLineFlag() {
		return generalLineFlag;
	}

	/**
	 * Returns the number of bits per value.
	 *
	 * @return The number of bits per value.
	 */
	public UBits getNumBits() {
		return numBits;
	}

	/**
	 * Returns the edge type flag.
	 *
	 * @return The edge type flag.
	 */
	public Flag getStraightFlag() {
		return straightFlag;
	}

	/**
	 * Returns the type flag.
	 *
	 * @return The type flag.
	 */
	public Flag getTypeFlag() {
		return typeFlag;
	}

	/**
	 * Returns the vertical line flag.
	 *
	 * @return The vertical line flag.
	 */
	public Flag getVertLineFlag() {
		return vertLineFlag;
	}
}