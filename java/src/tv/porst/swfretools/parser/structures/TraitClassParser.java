package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class TraitClassParser {

	public static TraitClass parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 slotId = EncodedU30Parser.parse(parser, fieldName + "::slot_id");
		final EncodedU30 classIndex = EncodedU30Parser.parse(parser, fieldName + "::classi");

		return new TraitClass(slotId, classIndex);
	}

}
