package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class TraitsInfo implements IFileElement {

	private final EncodedU30 name;
	private final ITraitKind data;
	private final EncodedU30 metaDataCount;
	private final EncodedU30List metaData;

	public TraitsInfo(final EncodedU30 name, final UINT8 kind, final ITraitKind data,
			final EncodedU30 metaDataCount, final EncodedU30List metaData) {

		this.name = name;
		this.data = data;
		this.metaDataCount = metaDataCount;
		this.metaData = metaData;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(name, data, metaDataCount, metaData);
	}

	@Override
	public int getBitPosition() {
		return name.getBitPosition();
	}

}
