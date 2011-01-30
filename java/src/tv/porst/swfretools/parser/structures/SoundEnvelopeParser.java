package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses SoundInfo structures.
 * 
 * @author sp
 *
 */
public final class SoundEnvelopeParser {

	/**
	 * Parses a SoundInfo structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static SoundEnvelope parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT32 pos44 = parseUINT32(parser, 0x00006, fieldName + "::Pos44");
		final UINT16 leftLevel = parseUINT16(parser, 0x00006, fieldName + "LeftLevel");
		final UINT16 rightLevel = parseUINT16(parser, 0x00006, fieldName + "RightLevel");

		return new SoundEnvelope(pos44, leftLevel, rightLevel);
	}
}