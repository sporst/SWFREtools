package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.actions.Action;

/**
 * Represents a ButtonCondAction structure.
 * 
 * @author sp
 *
 */
public final class ButtonCondAction {

	/**
	 * Offset in bytes from start of this field to next ButtonCondAction.
	 */
	private final UINT16 condActionSize;

	/**
	 * Idle to OverDown flag.
	 */
	private final Flag condIdleToOverDown;

	/**
	 * OutDown to Idle flag.
	 */
	private final Flag condOutDownToIdle;

	/**
	 * OverDown to OutDown flag.
	 */
	private final Flag condOutDownToOverDown;

	/**
	 * OverDown to OutDown flag.
	 */
	private final Flag condOverDownToOutDown;

	/**
	 * OverDown to OverUp flag.
	 */
	private final Flag condOverDownToOverUp;

	/**
	 * OverUp to OverDown flag.
	 */
	private final Flag condOverUpToOverDown;

	/**
	 * OverUp to Idle flag.
	 */
	private final Flag condOverUpToIdle;

	/**
	 * Idle to OverUp.
	 */
	private final Flag condIdleToOverUp;

	/**
	 * Key code.
	 */
	private final UBits condKeyPress;

	/**
	 * OverDown to Idle flag.
	 */
	private final Flag condOverDownToIdle;

	/**
	 * Actions to perform.
	 */
	private final List<Action> actions;

	/**
	 * Action end flag.
	 */
	private final UINT8 actionEndFlag;

	/**
	 * Creates a new ButtonCondAction object.
	 * 
	 * @param condActionSize Offset in bytes from start of this field to next ButtonCondAction.
	 * @param condIdleToOverDown Idle to OverDown flag.
	 * @param condOutDownToIdle OutDown to Idle flag.
	 * @param condOutDownToOverDown OutDown to OverDown flag.
	 * @param condOverDownToOutDown OverDown to OutDown flag.
	 * @param condOverDownToOverUp OverDown to OverUp flag.
	 * @param condOverUpToOverDown OverUp to OverDown flag.
	 * @param condOverUpToIdle OverUp to Idle flag.
	 * @param condIdleToOverUp Idle to OverUp flag.
	 * @param condKeyPress Key code.
	 * @param condOverDownToIdle OverDown to Idle.
	 * @param actionEndFlag Actions to perform.
	 * @param actions Action end flag.
	 */
	public ButtonCondAction(final UINT16 condActionSize, final Flag condIdleToOverDown,
			final Flag condOutDownToIdle, final Flag condOutDownToOverDown,
			final Flag condOverDownToOutDown, final Flag condOverDownToOverUp,
			final Flag condOverUpToOverDown, final Flag condOverUpToIdle,
			final Flag condIdleToOverUp, final UBits condKeyPress, final Flag condOverDownToIdle,
			final List<Action> actions, final UINT8 actionEndFlag) {

		this.condActionSize = condActionSize;
		this.condIdleToOverDown = condIdleToOverDown;
		this.condOutDownToIdle = condOutDownToIdle;
		this.condOutDownToOverDown = condOutDownToOverDown;
		this.condOverDownToOutDown = condOverDownToOutDown;
		this.condOverDownToOverUp = condOverDownToOverUp;
		this.condOverUpToOverDown = condOverUpToOverDown;
		this.condOverUpToIdle = condOverUpToIdle;
		this.condIdleToOverUp = condIdleToOverUp;
		this.condKeyPress = condKeyPress;
		this.condOverDownToIdle = condOverDownToIdle;
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
	 * Returns the offset in bytes from start of this field to next ButtonCondAction.
	 *
	 * @return The offset in bytes from start of this field to next ButtonCondAction.
	 */
	public UINT16 getCondActionSize() {
		return condActionSize;
	}

	/**
	 * Returns the Idle to OverDown flag.
	 *
	 * @return The Idle to OverDown flag.
	 */
	public Flag getCondIdleToOverDown() {
		return condIdleToOverDown;
	}

	/**
	 * Returns the Idle to OverUp.
	 *
	 * @return The Idle to OverUp.
	 */
	public Flag getCondIdleToOverUp() {
		return condIdleToOverUp;
	}

	/**
	 * Returns the key code.
	 *
	 * @return The key code.
	 */
	public UBits getCondKeyPress() {
		return condKeyPress;
	}

	/**
	 * Returns the OutDown to Idle flag.
	 *
	 * @return The OutDown to Idle flag.
	 */
	public Flag getCondOutDownToIdle() {
		return condOutDownToIdle;
	}

	/**
	 * Returns the OverDown to OutDown flag.
	 *
	 * @return The OverDown to OutDown flag.
	 */
	public Flag getCondOutDownToOverDown() {
		return condOutDownToOverDown;
	}

	/**
	 * Returns the OverDown to Idle flag.
	 *
	 * @return The OverDown to Idle flag.
	 */
	public Flag getCondOverDownToIdle() {
		return condOverDownToIdle;
	}

	/**
	 * Returns the OverDown to OutDown flag.
	 *
	 * @return The OverDown to OutDown flag.
	 */
	public Flag getCondOverDownToOutDown() {
		return condOverDownToOutDown;
	}

	/**
	 * Returns the OverDown to OverUp flag.
	 *
	 * @return The OverDown to OverUp flag.
	 */
	public Flag getCondOverDownToOverUp() {
		return condOverDownToOverUp;
	}

	/**
	 * Returns the OverUp to Idle flag.
	 *
	 * @return The OverUp to Idle flag.
	 */
	public Flag getCondOverUpToIdle() {
		return condOverUpToIdle;
	}

	/**
	 * Returns the OverUp to OverDown flag.
	 *
	 * @return The OverUp to OverDown flag.
	 */
	public Flag getCondOverUpToOverDown() {
		return condOverUpToOverDown;
	}
}