package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElementList<T extends IFileElement> implements Iterable<T> {

	private final List<T> elements;

	public ElementList(final List<T> elements) {
		this.elements = new ArrayList<T>(elements);
	}

	public int getBytePosition() {
		return elements.get(0).getBytePosition();
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayList<T>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}

}
