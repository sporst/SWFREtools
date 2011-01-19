package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses a Symbol structure.
 * 
 * @author sp
 *
 */
public final class SymbolParser {

	/**
	 * Parses a TextRecord2 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Symbol parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 tag = parseUINT16(parser, 0x00006, fieldName + "::Tag");
		final PString name = parseString(parser, 0x00006, fieldName + "::Name");

		return new Symbol(tag, name);
	}
}