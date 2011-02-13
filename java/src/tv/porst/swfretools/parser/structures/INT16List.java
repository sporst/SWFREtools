package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.INT16;

public class INT16List implements Iterable<INT16> {

	private final List<INT16> elements;

	public INT16List(final List<INT16> elements) {
		this.elements = new ArrayList<INT16>(elements);
	}

	public int getBytePosition() {
		return elements.get(0).getBytePosition();
	}

	@Override
	public Iterator<INT16> iterator() {
		return new ArrayList<INT16>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}
}
