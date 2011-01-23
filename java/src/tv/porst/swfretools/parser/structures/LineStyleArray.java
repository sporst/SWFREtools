package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

/**
 * Represents a LineStyleArray structure.
 * 
 * @author sp
 *
 */
public final class LineStyleArray {

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
	private final List<LineStyle> lineStyles;

	/**
	 * Creates a new LineStyleArray object.
	 * 
	 * @param lineStyleCount Count of line styles.
	 * @param lineStyleCountExtended Extended count of line styles.
	 * @param lineStyles Array of line styles.
	 */
	public LineStyleArray(final UINT8 lineStyleCount, final UINT16 lineStyleCountExtended,
			final List<LineStyle> lineStyles) {

		this.lineStyleCount = lineStyleCount;
		this.lineStyleCountExtended = lineStyleCountExtended;
		this.lineStyles = new ArrayList<LineStyle>(lineStyles);
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
	public List<LineStyle> getlineStyles() {
		return new ArrayList<LineStyle>(lineStyles);
	}
}