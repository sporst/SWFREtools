package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a LineStyleArray structure.
 * 
 * @author sp
 *
 */
public final class LineStyleArray implements IFileElement {

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
	private final LineStyleList lineStyles;

	/**
	 * Creates a new LineStyleArray object.
	 * 
	 * @param lineStyleCount Count of line styles.
	 * @param lineStyleCountExtended Extended count of line styles.
	 * @param lineStyles Array of line styles.
	 */
	public LineStyleArray(final UINT8 lineStyleCount, final UINT16 lineStyleCountExtended,
			final LineStyleList lineStyles) {

		this.lineStyleCount = lineStyleCount;
		this.lineStyleCountExtended = lineStyleCountExtended;
		this.lineStyles = lineStyles;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

	@Override
	public int getBitPosition() {
		return lineStyleCount.getBitPosition();
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
	public LineStyleList getLineStyles() {
		return lineStyles;
	}
}