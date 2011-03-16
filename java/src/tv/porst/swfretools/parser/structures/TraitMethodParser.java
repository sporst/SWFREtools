package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class TraitMethodParser {

	public static TraitMethod parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 dispId = EncodedU30Parser.parse(parser, fieldName + "::disp_id");
		final EncodedU30 method = EncodedU30Parser.parse(parser, fieldName + "::method");

		return new TraitMethod(dispId, method);
	}

}
