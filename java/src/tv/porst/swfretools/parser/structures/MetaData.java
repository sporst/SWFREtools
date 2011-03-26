package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class MetaData implements IFileElement {

	private final EncodedU30 name;
	private final EncodedU30 itemCount;
	private final ItemInfoList items;

	public MetaData(final EncodedU30 name, final EncodedU30 itemCount, final ItemInfoList items) {
		this.name = name;
		this.itemCount = itemCount;
		this.items = items;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(name, itemCount, items);
	}

	@Override
	public int getBitPosition() {
		return name.getBitPosition();
	}

}
