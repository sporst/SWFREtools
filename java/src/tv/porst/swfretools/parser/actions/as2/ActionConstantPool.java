package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.StringList;

public class ActionConstantPool extends ExtendedAction {

	private final UINT16 count;

	private final StringList constantPool;

	public ActionConstantPool(final UINT8 actionCode, final UINT16 length, final UINT16 count, final StringList constantPool) {
		super(actionCode, length);

		this.count = count;
		this.constantPool = constantPool;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), count, constantPool);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public StringList getConstantPool() {
		return constantPool;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getCount() {
		return count;
	}

}
