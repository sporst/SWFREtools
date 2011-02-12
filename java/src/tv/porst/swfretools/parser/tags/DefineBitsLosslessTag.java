package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.ByteArray;
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
	 * ZLIB compressed image data.
	 */
	private final ByteArray zlibBitmapData;

	/**
	 * Creates a new DefineBitsLossless tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param bitmapFormat Format of compressed data.
	 * @param bitmapWidth Bitmap width.
	 * @param bitmapHeight Bitmap height.
	 * @param bitmapColorTableSize Size of the color table.
	 * @param zlibBitmapData ZLIB compressed image data.
	 */
	public DefineBitsLosslessTag(final RecordHeader header, final UINT16 characterId,
			final UINT8 bitmapFormat, final UINT16 bitmapWidth, final UINT16 bitmapHeight,
			final UINT8 bitmapColorTableSize, final ByteArray zlibBitmapData) {

		super(header);

		this.characterId = characterId;
		this.bitmapFormat = bitmapFormat;
		this.bitmapWidth = bitmapWidth;
		this.bitmapHeight = bitmapHeight;
		this.bitmapColorTableSize = bitmapColorTableSize;
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
	 * Returns the ZLIB compressed image data.
	 * 
	 * @return The ZLIB compressed image data.
	 */
	public ByteArray getZlibBitmapData() {
		return zlibBitmapData;
	}
}