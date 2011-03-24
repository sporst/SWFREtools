package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;

public class StringList extends ElementList<AsciiString> {

	public StringList(final List<AsciiString> elements) {
		super(elements);
	}
}
