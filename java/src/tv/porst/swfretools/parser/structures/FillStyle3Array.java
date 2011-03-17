package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FillStyle3Array structure.
 * 
 * @author sp
 *
 */
public final class FillStyle3Array implements IFileElement {

	/**
	 * Count of fill styles.
	 */
	private final UINT8 fillStyleCount;

	/**
	 * Extended count of fill styles.
	 */
	private final UINT16 fillStyleCountExtended;

	/**
	 * Array of fill styles.
	 */
	private final FillStyle3List fillStyles;

	/**
	 * Creates a new FillStyle3Array object.
	 * 
	 * @param fillStyleCount Count of fill styles.
	 * @param fillStyleCountExtended Extended count of fill styles.
	 * @param fillStyles Array of fill styles.
	 */
	public FillStyle3Array(final UINT8 fillStyleCount, final UINT16 fillStyleCountExtended,
			final FillStyle3List fillStyles) {

		this.fillStyleCount = fillStyleCount;
		this.fillStyleCountExtended = fillStyleCountExtended;
		this.fillStyles = fillStyles;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(fillStyleCount, fillStyleCountExtended, fillStyles);
	}

	@Override
	public int getBitPosition() {
		return fillStyleCount.getBitPosition();
	}

	/**
	 * Returns the count of fill styles.
	 *
	 * @return The count of fill styles.
	 */
	public UINT8 getFillStyleCount() {
		return fillStyleCount;
	}

	/**
	 * Returns the extended count of fill styles.
	 *
	 * @return The extended count of fill styles.
	 */
	public UINT16 getFillStyleCountExtended() {
		return fillStyleCountExtended;
	}

	/**
	 * Returns the array of fill styles.
	 *
	 * @return The array of fill styles.
	 */
	public FillStyle3List getFillStyles() {
		return fillStyles;
	}
}