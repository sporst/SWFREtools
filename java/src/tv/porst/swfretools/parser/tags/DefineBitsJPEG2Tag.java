package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBitsJPEG2 tag.
 * 
 * @author sp
 *
 */
public final class DefineBitsJPEG2Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 characterId;

	/**
	 * Compressed image data.
	 */
	private final ByteArray imageData;

	/**
	 * Creates a new DefineBitsJPEG2 tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param imageData Compressed image data.
	 */
	public DefineBitsJPEG2Tag(final RecordHeader header, final UINT16 characterId, final ByteArray imageData) {
		super(header);

		this.characterId = characterId;
		this.imageData = imageData;
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
	public ByteArray getImageData() {
		return imageData;
	}
}