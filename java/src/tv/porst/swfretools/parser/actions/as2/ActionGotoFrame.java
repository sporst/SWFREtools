package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionGotoFrame extends ExtendedAction {

	private final UINT16 frame;

	public ActionGotoFrame(final UINT8 actionCode, final UINT16 length, final UINT16 frame) {
		super(actionCode, frame);

		this.frame = frame;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), frame);
	}

	public UINT16 getFrame() {
		return frame;
	}

}
