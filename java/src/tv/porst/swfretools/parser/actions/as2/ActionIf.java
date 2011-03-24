package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionIf extends ExtendedAction {

	private final INT16 branchOffset;

	public ActionIf(final UINT8 actionCode, final UINT16 length, final INT16 branchOffset) {
		super(actionCode, length);

		this.branchOffset = branchOffset;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), branchOffset);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public INT16 getBranchOffset() {
		return branchOffset;
	}

}
