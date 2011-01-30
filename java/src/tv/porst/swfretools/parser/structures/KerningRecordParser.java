package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.IParsedINTElement;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses KerningRecord structures.
 * 
 * @author sp
 */
public final class KerningRecordParser {

	/**
	 * Parses a KerningRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fontFlagsWideCodes Indicates if wide codes should be used.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static KerningRecord parse(final SWFBinaryParser parser, final boolean fontFlagsWideCodes, final String fieldName) throws SWFParserException {

		final IParsedINTElement fontKerningCode1 = fontFlagsWideCodes ? parseUINT16(parser, 0x00006, fieldName + "::FontKerningCode1") : parseUINT8(parser, 0x00006, fieldName + "::FontKerningCode1");
		final IParsedINTElement fontKerningCode2 = fontFlagsWideCodes ? parseUINT16(parser, 0x00006, fieldName + "::FontKerningCode2") : parseUINT8(parser, 0x00006, fieldName + "::FontKerningCode2");
		final INT16 fontKerningAdjustment = parseINT16(parser, 0x00006, fieldName + "::FontKerningAdjustment");

		return new KerningRecord(fontKerningCode1, fontKerningCode2, fontKerningAdjustment);
	}
}