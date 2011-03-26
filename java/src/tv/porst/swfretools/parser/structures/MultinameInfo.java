package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT8;

public class MultinameInfo {

	private final UINT8 kind;
	private final IMultiname data;

	public MultinameInfo(final UINT8 kind, final IMultiname data) {
		this.kind = kind;
		this.data = data;
	}

}
