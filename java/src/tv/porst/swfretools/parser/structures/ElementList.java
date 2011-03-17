package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ElementList<T extends IFileElement> implements Iterable<T>, IFileElement {

	private final List<T> elements;

	public ElementList(final List<T> elements) {
		this.elements = new ArrayList<T>(elements);
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
	public Iterator<T> iterator() {
		return new ArrayList<T>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}

}
