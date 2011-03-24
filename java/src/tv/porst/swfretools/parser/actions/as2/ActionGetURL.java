package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionGetURL extends ExtendedAction {

	private final AsciiString urlString;
	private final AsciiString targetString;

	public ActionGetURL(final UINT8 actionCode, final UINT16 length, final AsciiString urlString, final AsciiString targetString) {
		super(actionCode, length);

		this.urlString = urlString;
		this.targetString = targetString;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), urlString, targetString);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getTargetString() {
		return targetString;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getUrlString() {
		return urlString;
	}

}
