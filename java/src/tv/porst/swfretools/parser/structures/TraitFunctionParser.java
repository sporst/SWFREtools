package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class TraitFunctionParser {

	public static TraitFunction parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 slotId = EncodedU30Parser.parse(parser, fieldName + "::slot_id");
		final EncodedU30 function = EncodedU30Parser.parse(parser, fieldName + "::function");

		return new TraitFunction(slotId, function);
	}

}
