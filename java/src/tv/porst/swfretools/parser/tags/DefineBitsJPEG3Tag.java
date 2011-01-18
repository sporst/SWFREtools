package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBitsJPEG3 tag.
 * 
 * @author sp
 *
 */
public final class DefineBitsJPEG3Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 characterId;

	/**
	 * Count of bytes in ImageData.
	 */
	private final UINT32 alphaDataOffset;

	/**
	 * Compressed image data.
	 */
	private final ByteArray jpegData;

	/**
	 * ZLIB compressed array of alpha data.
	 */
	private final ByteArray bitmapAlphaData;

	/**
	 * Creates a new DefineBitsJPEG3 tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param alphaDataOffset Count of bytes in ImageData.
	 * @param jpegData Compressed image data.
	 * @param bitmapAlphaData ZLIB compressed array of alpha data.
	 */
	public DefineBitsJPEG3Tag(final RecordHeader header, final UINT16 characterId,
			final UINT32 alphaDataOffset, final ByteArray jpegData, final ByteArray bitmapAlphaData) {

		super(header);

		this.characterId = characterId;
		this.alphaDataOffset = alphaDataOffset;
		this.jpegData = jpegData;
		this.bitmapAlphaData = bitmapAlphaData;
	}

	/**
	 * Returns the count of bytes in ImageData.
	 * 
	 * @return The count of bytes in ImageData.
	 */
	public UINT32 getAlphaDataOffset() {
		return alphaDataOffset;
	}

	/**
	 * Returns the ZLIB compressed array of alpha data.
	 * 
	 * @return The ZLIB compressed array of alpha data.
	 */
	public ByteArray getBitmapAlphaData() {
		return bitmapAlphaData;
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
	 * Returns the compressed image data.
	 * 
	 * @return The compressed image data.
	 */
	public ByteArray getJpegData() {
		return jpegData;
	}
}