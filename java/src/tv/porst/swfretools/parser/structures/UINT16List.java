package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;

public class UINT16List implements Iterable<UINT16> {

	private final List<UINT16> elements;

	public UINT16List(final List<UINT16> elements) {
		this.elements = new ArrayList<UINT16>(elements);
	}

	public int getBytePosition() {
		return elements.get(0).getBytePosition();
	}

	@Override
	public Iterator<UINT16> iterator() {
		return new ArrayList<UINT16>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}
}
