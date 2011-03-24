package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionGotoLabel extends ExtendedAction {

	private final AsciiString label;

	public ActionGotoLabel(final UINT8 actionCode, final UINT16 length, final AsciiString label) {
		super(actionCode, length);

		this.label = label;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), label);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getLabel() {
		return label;
	}

}
