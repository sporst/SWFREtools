package tv.porst.swfretools.parser.structures;

/**
 * Represents an AlphaBitmapData structure.
 * 
 * @author sp
 *
 */
public final class AlphaBitmapData {

	/**
	 * Array of pixel colors.
	 */
	private final ARGB[] bitmapPixelData;

	/**
	 * Creates a new AlphaBitmapData object.
	 * 
	 * @param bitmapPixelData Array of pixel colors.
	 */
	public AlphaBitmapData(final ARGB[] bitmapPixelData) {

		this.bitmapPixelData = bitmapPixelData == null ? bitmapPixelData : bitmapPixelData.clone();
	}

	/**
	 * Returns the array of pixel colors.
	 *
	 * @return The array of pixel colors.
	 */
	public ARGB[] getBitmapPixelData() {
		return bitmapPixelData == null ? null : bitmapPixelData.clone();
	}
}