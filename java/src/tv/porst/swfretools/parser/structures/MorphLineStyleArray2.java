package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

/**
 * Represents a MorphLineStyleArray2 structure.
 * 
 * @author sp
 *
 */
public final class MorphLineStyleArray2 {

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
	private final List<MorphLineStyle2> lineStyles;

	/**
	 * Creates a new MorphLineStyleArray2 object.
	 * 
	 * @param lineStyleCount Count of line styles.
	 * @param lineStyleCountExtended Extended count of line styles.
	 * @param lineStyles Array of line styles.
	 */
	public MorphLineStyleArray2(final UINT8 lineStyleCount, final UINT16 lineStyleCountExtended,
			final List<MorphLineStyle2> lineStyles) {

		this.lineStyleCount = lineStyleCount;
		this.lineStyleCountExtended = lineStyleCountExtended;
		this.lineStyles = new ArrayList<MorphLineStyle2>(lineStyles);
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
	public List<MorphLineStyle2> getLineStyles() {
		return new ArrayList<MorphLineStyle2>(lineStyles);
	}
}