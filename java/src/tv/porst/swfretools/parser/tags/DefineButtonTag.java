package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.structures.ButtonRecord;
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
	private final List<ButtonRecord> characters;

	/**
	 * Actions to perform.
	 */
	private final List<Action> actions;

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
	 * @param actions Actions to perform.
	 * @param actionEndFlag Action end flag.
	 */
	public DefineButtonTag(final RecordHeader header, final UINT16 buttonId,
			final List<ButtonRecord> characters, final List<Action> actions,
			final UINT8 actionEndFlag) {

		super(header);

		this.buttonId = buttonId;
		this.characters = new ArrayList<ButtonRecord>(characters);
		this.actions = new ArrayList<Action>(actions);
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
	public List<Action> getActions() {
		return new ArrayList<Action>(actions);
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
	 * Returns the characters that make up the button.
	 * 
	 * @return The characters that make up the button.
	 */
	public List<ButtonRecord> getCharacters() {
		return new ArrayList<ButtonRecord>(characters);
	}
}