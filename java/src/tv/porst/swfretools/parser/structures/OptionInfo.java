package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;


public class OptionInfo implements IFileElement {

	private final EncodedU30 optionCount;
	private final OptionDetailList options;

	public OptionInfo(final EncodedU30 optionCount, final OptionDetailList options) {
		this.optionCount = optionCount;
		this.options = options;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(optionCount, options);
	}

	@Override
	public int getBitPosition() {
		return optionCount.getBitPosition();
	}

}
