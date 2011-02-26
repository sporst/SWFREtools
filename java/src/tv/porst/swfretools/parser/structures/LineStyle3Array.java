package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a LineStyle3Array structure.
 * 
 * @author sp
 *
 */
public class LineStyle3Array implements IFileElement {

	/**
	 * Count of line styles.
	 */
	private final UINT8 lineStyleCount;

	/**
	 * Extended count of line styles.
	 */
	private final UINT16 lineStyleCountExtended;

	/**
	 * Array of line styles.
	 */
	private final LineStyle3List lineStyles;

	/**
	 * Creates a new LineStyle3Array object.
	 * 
	 * @param lineStyleCount Count of line styles.
	 * @param lineStyleCountExtended Extended count of line styles.
	 * @param lineStyles Array of line styles.
	 */
	public LineStyle3Array(final UINT8 lineStyleCount, final UINT16 lineStyleCountExtended,
			final LineStyle3List lineStyles) {

		this.lineStyleCount = lineStyleCount;
		this.lineStyleCountExtended = lineStyleCountExtended;
		this.lineStyles = lineStyles;
	}

	@Override
	public int getBytePosition() {
		return lineStyleCount.getBytePosition();
	}

	/**
	 * Returns the count of line styles.
	 *
	 * @return The count of line styles.
	 */
	public UINT8 getLineStyleCount() {
		return lineStyleCount;
	}

	/**
	 * Returns the extended count of line styles.
	 *
	 * @return The extended count of line styles.
	 */
	public UINT16 getLineStyleCountExtended() {
		return lineStyleCountExtended;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public LineStyle3List getLineStyles() {
		return lineStyles;
	}
}