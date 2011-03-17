package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.ButtonRecordList;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineButton tag.
 * 
 * @author sp
 *
 */
public final class DefineButtonTag extends Tag {

	/**
	 * ID for this character.
	 */
	private final UINT16 buttonId;

	/**
	 * Characters that make up the button.
	 */
	private final ButtonRecordList characters;

	/**
	 * Character end flag.
	 */
	private final UINT8 characterEndFlag;

	/**
	 * Actions to perform.
	 */
	private final ActionList actions;

	/**
	 * Action end flag.
	 */
	private final UINT8 actionEndFlag;

	/**
	 * Creates a new DefineButton tag object.
	 * 
	 * @param header Tag header.
	 * @param buttonId ID for this character.
	 * @param characters Characters that make up the button.
	 * @param characterEndFlag Character end flag.
	 * @param actions Actions to perform.
	 * @param actionEndFlag Action end flag.
	 */
	public DefineButtonTag(final RecordHeader header, final UINT16 buttonId,
			final ButtonRecordList characters, final UINT8 characterEndFlag, final ActionList actions,
			final UINT8 actionEndFlag) {

		super(header);

		this.buttonId = buttonId;
		this.characters = characters;
		this.characterEndFlag = characterEndFlag;
		this.actions = actions;
		this.actionEndFlag = actionEndFlag;
	}

	/**
	 * Returns the action end flag.
	 * 
	 * @return The action end flag.
	 */
	public UINT8 getActionEndFlag() {
		return actionEndFlag;
	}

	/**
	 * Returns the actions to perform.
	 * 
	 * @return The actions to perform.
	 */
	public ActionList getActions() {
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
	public ButtonRecordList getCharacters() {
		return characters;
	}
}