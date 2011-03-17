package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ParsedINTElementList implements Iterable<IParsedINTElement>, IFileElement{

	private final List<IParsedINTElement> elements;

	public ParsedINTElementList(final List<IParsedINTElement> elements) {
		this.elements = new ArrayList<IParsedINTElement>(elements);
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
	public Iterator<IParsedINTElement> iterator() {
		return new ArrayList<IParsedINTElement>(elements).iterator();
	}

	public int size() {
		return elements.size();
	}
}
