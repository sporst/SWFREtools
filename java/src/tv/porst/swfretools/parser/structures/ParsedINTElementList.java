package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.IParsedINTElement;

public class ParsedINTElementList implements Iterable<IParsedINTElement>{

	private final List<IParsedINTElement> elements;

	public ParsedINTElementList(final List<IParsedINTElement> elements) {
		this.elements = new ArrayList<IParsedINTElement>(elements);
	}

	public int getBytePosition() {
		return elements.get(0).getBytePosition();
	}

	@Override
	public Iterator<IParsedINTElement> iterator() {
		return new ArrayList<IParsedINTElement>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}
}
