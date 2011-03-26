package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class NamespaceSetInfoParser {

	public static NamespaceSetInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 count = EncodedU30Parser.parse(parser, fieldName + "::count");

		final List<EncodedU30> namespaces = new ArrayList<EncodedU30>();

		for (int i=0;i<count.value();i++) {
			namespaces.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::ns[%d]", i)));
		}

		return new NamespaceSetInfo(count, new EncodedU30List(namespaces));
	}

}
