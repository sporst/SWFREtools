package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.structures.ButtonRecord2;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineButton2 tag.
 * 
 * @author sp
 *
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
	private final List<ButtonRecord2> characters;

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
	 * @param reservedFlags Reserved flags.
	 * @param trackAsMenu Track as menu flag.
	 * @param actionOffset Offset in bytes from the start of this field to the first action.
	 * @param characters Characters that make up the button.
	 * @param actions Actions to perform.
	 * @param actionEndFlag Action end flag.
	 */
	public DefineButton2Tag(final RecordHeader header, final UINT16 buttonId,
			final UBits reservedFlags, final Flag trackAsMenu, final UINT16 actionOffset,
			final List<ButtonRecord2> characters, final List<Action> actions,
			final UINT8 actionEndFlag) {

		super(header);

		this.buttonId = buttonId;
		this.reservedFlags = reservedFlags;
		this.trackAsMenu = trackAsMenu;
		this.actionOffset = actionOffset;
		this.characters = new ArrayList<ButtonRecord2>(characters);
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
	public List<ButtonRecord2> getCharacters() {
		return new ArrayList<ButtonRecord2>(characters);
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