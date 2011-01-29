package tv.porst.swfretools.parser.structures;

/**
 * Represents a ColormapData structure.
 * 
 * @author sp
 *
 */
public final class ColormapData {

	/**
	 * Mapping from color indices to RGB values.
	 */
	private final RGB[] colorTableRGB;

	/**
	 * Array of color indices.
	 */
	private final ByteArray colormapPixelData;

	/**
	 * Creates a new ColormapData object.
	 * 
	 * @param colorTableRGB Mapping from color indices to RGB values.
	 * @param colormapPixelData Array of color indices.
	 */
	public ColormapData(final RGB[] colorTableRGB, final ByteArray colormapPixelData) {

		this.colorTableRGB = colorTableRGB == null ? colorTableRGB : colorTableRGB.clone();
		this.colormapPixelData = colormapPixelData;
	}

	/**
	 * Returns the array of color indices.
	 *
	 * @return The array of color indices.
	 */
	public ByteArray getColormapPixelData() {
		return colormapPixelData;
	}

	/**
	 * Returns the mapping from color indices to RGB values.
	 * 
	 * @return The mapping from color indices to RGB values.
	 */
	public RGB[] getColorTableRGB() {
		return colorTableRGB == null ? colorTableRGB : colorTableRGB.clone();
	}
}