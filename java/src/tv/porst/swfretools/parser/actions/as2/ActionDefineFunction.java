package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ActionList;
import tv.porst.swfretools.parser.structures.StringList;

public class ActionDefineFunction extends ExtendedAction {

	private final AsciiString functionName;
	private final UINT16 numParams;
	private final StringList params;
	private final UINT16 codeSize;
	private final ActionList code;

	public ActionDefineFunction(final UINT8 actionCode, final UINT16 length, final AsciiString functionName, final UINT16 numParams, final StringList params, final UINT16 codeSize, final ActionList code) {
		super(actionCode, length);

		this.functionName = functionName;
		this.numParams = numParams;
		this.params = params;
		this.codeSize = codeSize;
		this.code = code;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), functionName, numParams, params, codeSize, code);
	}
}