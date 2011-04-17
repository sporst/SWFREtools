package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.ButtonCondActionList;
import tv.porst.swfretools.parser.structures.ButtonRecord2List;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineButton2 tag.
 */
public final class DefineButton2Tag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 buttonId;

	/**
	 * Reserved flags.
	 */
	private final UBits reservedFlags;

	/**
	 * Track as menu flag.
	 */
	private final Flag trackAsMenu;

	/**
	 * Offset in bytes from the start of this field to the first action.
	 */
	private final UINT16 actionOffset;

	/**
	 * Characters that make up the button.
	 */
	private final ButtonRecord2List characters;

	/**
	 * Character end flag.
	 */
	private final UINT8 characterEndFlag;

	/**
	 * Actions to perform.
	 */
	private final ButtonCondActionList actions;

	/**
	 * Creates a new DefineButton tag object.
	 * 
	 * @param header Tag header.
	 * @param buttonId ID for this character.
	 * @param reservedFlags Reserved flags.
	 * @param trackAsMenu Track as menu flag.
	 * @param actionOffset Offset in bytes from the start of this field to the first action.
	 * @param characters Characters that make up the button.
	 * @param characterEndFlag Character end flag.
	 * @param actions Actions to perform.
	 */
	public DefineButton2Tag(final RecordHeader header, final UINT16 buttonId,
			final UBits reservedFlags, final Flag trackAsMenu, final UINT16 actionOffset,
			final ButtonRecord2List characters, final UINT8 characterEndFlag, final ButtonCondActionList actions) {

		super(header);

		this.buttonId = buttonId;
		this.reservedFlags = reservedFlags;
		this.trackAsMenu = trackAsMenu;
		this.actionOffset = actionOffset;
		this.characters = characters;
		this.characterEndFlag = characterEndFlag;
		this.actions = actions;
	}

	/**
	 * Returns the offset in bytes from the start of this field to the first action.
	 * 
	 * @return The offset in bytes from the start of this field to the first action.
	 */
	public UINT16 getActionOffset() {
		return actionOffset;
	}

	/**
	 * Returns the actions to perform.
	 * 
	 * @return The actions to perform.
	 */
	public ButtonCondActionList getActions() {
		return actions;
	}

	/**
	 * Returns the ID for this character.
	 * 
	 * @return The ID for this character.
	 */
	public UINT16 getButtonId() {
		return buttonId;
	}

	/**
	 * Returns the character end flag.
	 *
	 * @return The character end flag.
	 */
	public UINT8 getCharacterEndFlag() {
		return characterEndFlag;
	}

	/**
	 * Returns the characters that make up the button.
	 * 
	 * @return The characters that make up the button.
	 */
	public ButtonRecord2List getCharacters() {
		return characters;
	}

	/**
	 * Returns the reserved flags.
	 * 
	 * @return The reserved flags.
	 */
	public UBits getReservedFlags() {
		return reservedFlags;
	}

	/**
	 * Returns the track as menu flag.
	 * 
	 * @return The track as menu flag.
	 */
	public Flag getTrackAsMenu() {
		return trackAsMenu;
	}
}