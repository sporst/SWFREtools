package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class UINT16List implements Iterable<UINT16>, IFileElement {

	private final List<UINT16> elements;

	public UINT16List(final List<UINT16> elements) {
		this.elements = new ArrayList<UINT16>(elements);
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(elements);
	}

	@Override
	public int getBitPosition() {
		return elements.get(0).getBitPosition();
	}

	@Override
	public Iterator<UINT16> iterator() {
		return new ArrayList<UINT16>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}
}
