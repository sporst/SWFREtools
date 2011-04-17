package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBitsJPEG4 tag.
 */
public final class DefineBitsJPEG4Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 characterId;

	/**
	 * Parameter to be fed into the deblocking filter.
	 */
	private final UINT16 deblockParam;

	/**
	 * Count of bytes in ImageData.
	 */
	private final UINT32 alphaDataOffset;

	/**
	 * Compressed image data.
	 */
	private final ByteArray imageData;

	/**
	 * ZLIB compressed array of alpha data.
	 */
	private final ByteArray bitmapAlphaData;

	/**
	 * Creates a new DefineBitsJPEG4 tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param alphaDataOffset Count of bytes in ImageData.
	 * @param deblockParam Parameter to be fed into the deblocking filter.
	 * @param imageData Compressed image data.
	 * @param bitmapAlphaData ZLIB compressed array of alpha data.
	 */
	public DefineBitsJPEG4Tag(final RecordHeader header, final UINT16 characterId,
			final UINT32 alphaDataOffset, final UINT16 deblockParam, final ByteArray imageData,
			final ByteArray bitmapAlphaData) {

		super(header);

		this.characterId = characterId;
		this.alphaDataOffset = alphaDataOffset;
		this.deblockParam = deblockParam;
		this.imageData = imageData;
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
	 * Returns the parameter to be fed into the deblocking filter.
	 * 
	 * @return The parameter to be fed into the deblocking filter.
	 */
	public UINT16 getDeblockParam() {
		return deblockParam;
	}

	/**
	 * Returns the compressed image data.
	 * 
	 * @return The compressed image data.
	 */
	public ByteArray getImageData() {
		return imageData;
	}
}