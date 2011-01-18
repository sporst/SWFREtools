package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.BitmapData15;
import tv.porst.swfretools.parser.structures.BitmapData24;
import tv.porst.swfretools.parser.structures.ColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBitsLossless tag.
 * 
 * @author sp
 *
 */
public final class DefineBitsLosslessTag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 characterId;

	/**
	 * Format of compressed data.
	 */
	private final UINT8 bitmapFormat;

	/**
	 * Bitmap width.
	 */
	private final UINT16 bitmapWidth;

	/**
	 * Bitmap height.
	 */
	private final UINT16 bitmapHeight;

	/**
	 * Size of the color table.
	 */
	private final UINT8 bitmapColorTableSize;

	/**
	 * ZLIB compressed bitmap data.
	 */
	private final ColormapData zlibColormapData;

	/**
	 * ZLIB compressed bitmap data.
	 */
	private final BitmapData15 zlibBitmapData15;

	/**
	 * ZLIB compressed bitmap data.
	 */
	private final BitmapData24 zlibBitmapData24;

	/**
	 * Creates a new DefineBitsLossless tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param bitmapFormat Format of compressed data.
	 * @param bitmapWidth Bitmap width.
	 * @param bitmapHeight Bitmap height.
	 * @param bitmapColorTableSize Size of the color table.
	 * @param zlibColormapData ZLIB compressed bitmap data.
	 * @param zlibBitmapData15 ZLIB compressed bitmap data.
	 * @param zlibBitmapData24 ZLIB compressed bitmap data.
	 */
	public DefineBitsLosslessTag(final RecordHeader header, final UINT16 characterId,
			final UINT8 bitmapFormat, final UINT16 bitmapWidth, final UINT16 bitmapHeight,
			final UINT8 bitmapColorTableSize, final ColormapData zlibColormapData,
			final BitmapData15 zlibBitmapData15, final BitmapData24 zlibBitmapData24) {

		super(header);

		this.characterId = characterId;
		this.bitmapFormat = bitmapFormat;
		this.bitmapWidth = bitmapWidth;
		this.bitmapHeight = bitmapHeight;
		this.bitmapColorTableSize = bitmapColorTableSize;
		this.zlibColormapData = zlibColormapData;
		this.zlibBitmapData15 = zlibBitmapData15;
		this.zlibBitmapData24 = zlibBitmapData24;
	}

	/**
	 * Returns the size of the color table.
	 * 
	 * @return The size of the color table.
	 */
	public UINT8 getBitmapColorTableSize() {
		return bitmapColorTableSize;
	}

	/**
	 * Returns the format of compressed data.
	 * 
	 * @return The format of compressed data.
	 */
	public UINT8 getBitmapFormat() {
		return bitmapFormat;
	}

	/**
	 * Returns the bitmap height.
	 * 
	 * @return The bitmap height.
	 */
	public UINT16 getBitmapHeight() {
		return bitmapHeight;
	}

	/**
	 * Returns the bitmap width.
	 * 
	 * @return The bitmap width.
	 */
	public UINT16 getBitmapWidth() {
		return bitmapWidth;
	}

	/**
	 * Returns the ID for this character.
	 * 
	 * @return The ID for this character.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the ZLIB compressed bitmap data.
	 * 
	 * @return The ZLIB compressed bitmap data.
	 */
	public BitmapData15 getZlibBitmapData15() {
		return zlibBitmapData15;
	}

	/**
	 * Returns the ZLIB compressed bitmap data.
	 * 
	 * @return The ZLIB compressed bitmap data.
	 */
	public BitmapData24 getZlibBitmapData24() {
		return zlibBitmapData24;
	}

	/**
	 * Returns the ZLIB compressed bitmap data.
	 * 
	 * @return The ZLIB compressed bitmap data.
	 */
	public ColormapData getZlibColormapData() {
		return zlibColormapData;
	}
}