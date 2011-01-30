package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a FillStyle3Array structure.
 * 
 * @author sp
 *
 */
public final class FillStyle3Array {

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
	private final List<FillStyle3> fillStyles;

	/**
	 * Creates a new FillStyle3Array object.
	 * 
	 * @param fillStyleCount Count of fill styles.
	 * @param fillStyleCountExtended Extended count of fill styles.
	 * @param fillStyles Array of fill styles.
	 */
	public FillStyle3Array(final UINT8 fillStyleCount, final UINT16 fillStyleCountExtended,
			final List<FillStyle3> fillStyles) {

		this.fillStyleCount = fillStyleCount;
		this.fillStyleCountExtended = fillStyleCountExtended;
		this.fillStyles = new ArrayList<FillStyle3>(fillStyles);
	}

	/**
	 * Returns the count of fill styles.
	 *
	 * @return The count of fill styles.
	 */
	public UINT8 getFillStyle3Count() {
		return fillStyleCount;
	}

	/**
	 * Returns the extended count of fill styles.
	 *
	 * @return The extended count of fill styles.
	 */
	public UINT16 getFillStyle3CountExtended() {
		return fillStyleCountExtended;
	}

	/**
	 * Returns the array of fill styles.
	 *
	 * @return The array of fill styles.
	 */
	public List<FillStyle3> getFillStyle3s() {
		return new ArrayList<FillStyle3>(fillStyles);
	}
}