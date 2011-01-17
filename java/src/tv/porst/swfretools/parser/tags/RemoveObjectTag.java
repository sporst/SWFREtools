package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a RemoveObject tag.
 * 
 * @author sp
 *
 */
public final class RemoveObjectTag extends Tag {

	/**
	 * ID of character to remove.
	 */
	private final UINT16 characterId;

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * Creates a new RemoveObject tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID of character to remove.
	 * @param depth Depth of character.
	 */
	public RemoveObjectTag(final RecordHeader header, final UINT16 characterId, final UINT16 depth) {

		super(header);

		SWFParserHelpers.checkNull(characterId, "CharacterId");
		SWFParserHelpers.checkNull(depth, "Depth");

		this.characterId = characterId;
		this.depth = depth;
	}

	/**
	 * Returns the ID of character to remove.
	 * 
	 * @return The ID of character to remove.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the depth of character.
	 * 
	 * @return The depth of character.
	 */
	public UINT16 getDepth() {
		return depth;
	}
}