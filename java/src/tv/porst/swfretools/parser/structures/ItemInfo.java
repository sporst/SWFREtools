package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ItemInfo implements IFileElement {

	private final EncodedU30 key;
	private final EncodedU30 value;

	public ItemInfo(final EncodedU30 key, final EncodedU30 value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(key, value);
	}

	@Override
	public int getBitPosition() {
		return key.getBitPosition();
	}

}
