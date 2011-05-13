package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class GenericVectorParser {

	public static GenericVector parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 typeDefinition = EncodedU30Parser.parse(parser, fieldName + "::type_definition");
		final EncodedU30 paramCount = EncodedU30Parser.parse(parser, fieldName + "::param_count");

		final List<EncodedU30> params = new ArrayList<EncodedU30>();

		for (int i = 0; i < paramCount.value(); i++) {
			params.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::param[%d]", i)));
		}

		return new GenericVector(typeDefinition, paramCount, new EncodedU30List(params));
	}

}
