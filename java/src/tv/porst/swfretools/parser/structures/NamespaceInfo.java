package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class NamespaceInfo implements IFileElement {

	private final UINT8 kind;
	private final EncodedU30 name;

	public NamespaceInfo(final UINT8 kind, final EncodedU30 name) {
		this.kind = kind;
		this.name = name;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(kind, name);
	}

	@Override
	public int getBitPosition() {
		return kind.getBitPosition();
	}

}
