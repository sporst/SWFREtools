package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class TraitSlotParser {

	public static TraitSlot parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final EncodedU30 slotId = EncodedU30Parser.parse(parser, fieldName + "::slot_id");
		final EncodedU30 typeName = EncodedU30Parser.parse(parser, fieldName + "::type_name");
		final EncodedU30 vIndex = EncodedU30Parser.parse(parser, fieldName + "::vindex");
		final UINT8 vkind = parseUINT8(parser, 0x00006, fieldName + "::vkind");

		return new TraitSlot(slotId, typeName, vIndex, vkind);
	}

}
