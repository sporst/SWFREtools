package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineBits tag.
 */
public final class DefineBitsTag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 characterId;

	/**
	 * JPEG compressed image.
	 */
	private final ByteArray jpegData;

	/**
	 * Creates a new DefineBits tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this character.
	 * @param jpegData JPEG compressed image.
	 */
	public DefineBitsTag(final RecordHeader header, final UINT16 characterId, final ByteArray jpegData) {
		super(header);

		this.characterId = characterId;
		this.jpegData = jpegData;
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
	 * Returns the JPEG compressed image.
	 * 
	 * @return The JPEG compressed image.
	 */
	public ByteArray getJpegData() {
		return jpegData;
	}
}