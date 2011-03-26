package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT8;

public class NamespaceInfo {

	private final UINT8 kind;
	private final EncodedU30 name;

	public NamespaceInfo(final UINT8 kind, final EncodedU30 name) {
		this.kind = kind;
		this.name = name;
	}

}
