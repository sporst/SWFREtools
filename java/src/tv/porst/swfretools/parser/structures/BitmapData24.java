package tv.porst.swfretools.parser.structures;

/**
 * Represents a BitmapData24 structure.
 * 
 * @author sp
 *
 */
public final class BitmapData24 {

	/**
	 * Array of pixel colors.
	 */
	private final Pix24[] bitmapPixelData;

	/**
	 * Creates a new BitmapData24 object.
	 * 
	 * @param bitmapPixelData Array of pixel colors.
	 */
	public BitmapData24(final Pix24[] bitmapPixelData) {

		this.bitmapPixelData = bitmapPixelData == null ? bitmapPixelData : bitmapPixelData.clone();
	}

	/**
	 * Returns the array of pixel colors.
	 *
	 * @return The array of pixel colors.
	 */
	public Pix24[] getBitmapPixelData() {
		return bitmapPixelData == null ? bitmapPixelData : bitmapPixelData.clone();
	}
}