package tv.porst.swfretools.parser.structures;

/**
 * Represents a BitmapData15 structure.
 * 
 * @author sp
 *
 */
public final class BitmapData15 {

	/**
	 * Array of pixel colors.
	 */
	private final Pix15[] bitmapPixelData;

	/**
	 * Creates a new BitmapData15 object.
	 * 
	 * @param bitmapPixelData Array of pixel colors.
	 */
	public BitmapData15(final Pix15[] bitmapPixelData) {

		this.bitmapPixelData = bitmapPixelData == null ? bitmapPixelData : bitmapPixelData.clone();
	}

	/**
	 * Returns the array of pixel colors.
	 *
	 * @return The array of pixel colors.
	 */
	public Pix15[] getBitmapPixelData() {
		return bitmapPixelData == null ? bitmapPixelData : bitmapPixelData.clone();
	}
}