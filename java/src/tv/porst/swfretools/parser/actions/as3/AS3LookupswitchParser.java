package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.EncodedS24;
import tv.porst.swfretools.parser.structures.EncodedS24Parser;
import tv.porst.swfretools.parser.structures.EncodedU30;
import tv.porst.swfretools.parser.structures.EncodedU30Parser;

public class AS3LookupswitchParser {

	public static AS3Lookupswitch parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final EncodedS24 defaultOffset = EncodedS24Parser.parse(parser, fieldName + "::default_offset");
		final EncodedU30 caseCounts = EncodedU30Parser.parse(parser, fieldName + "::case_counts");

		final List<EncodedS24> caseOffsets = new ArrayList<EncodedS24>();

		for (int i=0;i<caseCounts.value();i++) {
			caseOffsets.add(EncodedS24Parser.parse(parser, fieldName + String.format("::case_offsets[%d]", i)));
		}

		return new AS3Lookupswitch(opcode, defaultOffset, caseCounts, new EncodedS24List(caseOffsets));
	}
}
