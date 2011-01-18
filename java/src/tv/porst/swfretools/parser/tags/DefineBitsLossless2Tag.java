package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.AlphaBitmapData;
import tv.porst.swfretools.parser.structures.AlphaColormapData;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBitsLossless2 tag.
 * 
 * @author sp
 *
 */
public final class DefineBitsLossless2Tag extends Tag {

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
	private final AlphaColormapData zlibColormapData;

	/**
	 * ZLIB compressed bitmap data.
	 */
	private final AlphaBitmapData zlibBitmapData;

	/**
	 * Creates a new DefineBitsLossless2 tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param bitmapFormat Format of compressed data.
	 * @param bitmapWidth Bitmap width.
	 * @param bitmapHeight Bitmap height.
	 * @param bitmapColorTableSize Size of the color table.
	 * @param zlibColormapData ZLIB compressed bitmap data.
	 */
	public DefineBitsLossless2Tag(final RecordHeader header, final UINT16 characterId,
			final UINT8 bitmapFormat, final UINT16 bitmapWidth, final UINT16 bitmapHeight,
			final UINT8 bitmapColorTableSize, final AlphaColormapData zlibColormapData,
			final AlphaBitmapData zlibBitmapData) {

		super(header);

		this.characterId = characterId;
		this.bitmapFormat = bitmapFormat;
		this.bitmapWidth = bitmapWidth;
		this.bitmapHeight = bitmapHeight;
		this.bitmapColorTableSize = bitmapColorTableSize;
		this.zlibColormapData = zlibColormapData;
		this.zlibBitmapData = zlibBitmapData;
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
	public AlphaBitmapData getZlibBitmapData() {
		return zlibBitmapData;
	}

	/**
	 * Returns the ZLIB compressed bitmap data.
	 * 
	 * @return The ZLIB compressed bitmap data.
	 */
	public AlphaColormapData getZlibColormapData() {
		return zlibColormapData;
	}
}