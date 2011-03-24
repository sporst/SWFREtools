package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT8;

public class SimpleAction extends Action {

	public SimpleAction(final UINT8 actionCode) {
		super(actionCode);
	}

	@Override
	public int getBitLength() {
		return getActionCode().getBitLength();
	}
}
