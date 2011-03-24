package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionSetTarget extends ExtendedAction {

	private final AsciiString targetName;

	public ActionSetTarget(final UINT8 actionCode, final UINT16 length, final AsciiString targetName) {
		super(actionCode, length);

		this.targetName = targetName;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), targetName);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getTargetName() {
		return targetName;
	}

}
