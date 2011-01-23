package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

/**
 * Represents a LineStyle4Array structure.
 * 
 * @author sp
 *
 */
public final class LineStyle4Array {

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
	private final List<LineStyle4> lineStyles;

	/**
	 * Creates a new LineStyle4Array object.
	 * 
	 * @param lineStyleCount Count of line styles.
	 * @param lineStyleCountExtended Extended count of line styles.
	 * @param lineStyles Array of line styles.
	 */
	public LineStyle4Array(final UINT8 lineStyleCount, final UINT16 lineStyleCountExtended,
			final List<LineStyle4> lineStyles) {

		this.lineStyleCount = lineStyleCount;
		this.lineStyleCountExtended = lineStyleCountExtended;
		this.lineStyles = new ArrayList<LineStyle4>(lineStyles);
	}

	/**
	 * Returns the count of line styles.
	 *
	 * @return The count of line styles.
	 */
	public UINT8 getlineStyleCount() {
		return lineStyleCount;
	}

	/**
	 * Returns the extended count of line styles.
	 *
	 * @return The extended count of line styles.
	 */
	public UINT16 getlineStyleCountExtended() {
		return lineStyleCountExtended;
	}

	/**
	 * Returns the array of line styles.
	 *
	 * @return The array of line styles.
	 */
	public List<LineStyle4> getlineStyles() {
		return lineStyles;
	}
}