package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;

public abstract class Action implements IFileElement {

	private final UINT8 actionCode;

	public Action(final UINT8 actionCode) {
		this.actionCode = actionCode;
	}

	public UINT8 getActionCode() {
		return actionCode;
	}

	@Override
	public int getBitPosition() {
		return getActionCode().getBitPosition();
	}
}
