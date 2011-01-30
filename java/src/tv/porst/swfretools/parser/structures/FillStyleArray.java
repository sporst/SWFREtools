package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a FillStyleArray structure.
 * 
 * @author sp
 *
 */
public final class FillStyleArray {

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
	private final List<FillStyle> fillStyles;

	/**
	 * Creates a new FillStyleArray object.
	 * 
	 * @param fillStyleCount Count of fill styles.
	 * @param fillStyleCountExtended Extended count of fill styles.
	 * @param fillStyles Array of fill styles.
	 */
	public FillStyleArray(final UINT8 fillStyleCount, final UINT16 fillStyleCountExtended,
			final List<FillStyle> fillStyles) {

		this.fillStyleCount = fillStyleCount;
		this.fillStyleCountExtended = fillStyleCountExtended;
		this.fillStyles = new ArrayList<FillStyle>(fillStyles);
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
	public List<FillStyle> getFillStyles() {
		return new ArrayList<FillStyle>(fillStyles);
	}
}