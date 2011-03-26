package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class MultinameInfo implements IFileElement {

	private final UINT8 kind;
	private final IMultiname data;

	public MultinameInfo(final UINT8 kind, final IMultiname data) {
		this.kind = kind;
		this.data = data;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(kind, data);
	}

	@Override
	public int getBitPosition() {
		return kind.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public IMultiname getData() {
		return data;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getKind() {
		return kind;
	}

}
