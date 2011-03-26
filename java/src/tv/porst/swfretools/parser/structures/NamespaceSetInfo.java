package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class NamespaceSetInfo implements IFileElement {

	private final EncodedU30 count;
	private final EncodedU30List namespaces;

	public NamespaceSetInfo(final EncodedU30 count, final EncodedU30List namespaces) {
		this.count = count;
		this.namespaces = namespaces;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(count, namespaces);
	}

	@Override
	public int getBitPosition() {
		return count.getBitPosition();
	}

}
