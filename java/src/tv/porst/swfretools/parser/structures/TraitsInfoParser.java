package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class TraitsInfoParser {

	private static ITraitKind parseTraitKind(final SWFBinaryParser parser, final UINT8 kind, final String fieldName) throws SWFParserException {
		switch (kind.value() & 0xF) {
		case 0: return TraitSlotParser.parse(parser, fieldName);
		case 1: return TraitMethodParser.parse(parser, fieldName);
		case 2: return TraitMethodParser.parse(parser, fieldName);
		case 3: return TraitMethodParser.parse(parser, fieldName);
		case 4: return TraitClassParser.parse(parser, fieldName);
		case 5: return TraitFunctionParser.parse(parser, fieldName);
		case 6: return TraitSlotParser.parse(parser, fieldName);
		}

		throw new IllegalStateException("Unknown trait kinds");
	}

	public static TraitsInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");
		final UINT8 kind = parseUINT8(parser, 0x00006, fieldName + "::kind");
		final ITraitKind data = parseTraitKind(parser, kind, fieldName + "::data");

		final boolean hasMetaData = (kind.value() >>> 4 & 0x4) != 0;

		final EncodedU30 metaDataCount = hasMetaData ? EncodedU30Parser.parse(parser, fieldName + "::metadata_count") : null;

		final List<EncodedU30> metaData = hasMetaData ? new ArrayList<EncodedU30>() : null;

		if (hasMetaData) {
			for (int i=0;i<metaDataCount.value();i++) {
				metaData.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::meta_data[%d]", i)));
			}
		}

		return new TraitsInfo(name, kind, data, metaDataCount, new EncodedU30List(metaData));
	}

}
