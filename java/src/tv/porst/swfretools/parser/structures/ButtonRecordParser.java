package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ButtonRecord structures.
 * 
 * @author sp
 */
public final class ButtonRecordParser {

	/**
	 * Parses a ButtonRecord structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ButtonRecord parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UBits buttonReserved = parseUBits(parser, 2, 0x00006, fieldName + "::ButtonReserved");
		final Flag buttonHasBlendMode = parseFlag(parser, 0x00006, fieldName + "::ButtonHasBlendMode");
		final Flag buttonHasFilterList = parseFlag(parser, 0x00006, fieldName + "::ButtonHasFilterList");
		final Flag buttonStateHitTest = parseFlag(parser, 0x00006, fieldName + "::ButtonStateHitTest");
		final Flag buttonStateDown = parseFlag(parser, 0x00006, fieldName + "::ButtonStateDown");
		final Flag buttonStateOver = parseFlag(parser, 0x00006, fieldName + "::ButtonStateOver");
		final Flag buttonStateUp = parseFlag(parser, 0x00006, fieldName + "::ButtonStateUp");
		final UINT16 characterID = parseUINT16(parser, 0x00006, fieldName + "::CharacterID");
		final UINT16 placeDepth = parseUINT16(parser, 0x00006, fieldName + "::PlaceDepth");
		final Matrix placeMatrix = MatrixParser.parse(parser, fieldName + "::PlaceMatrix");

		return new ButtonRecord(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver,
				buttonStateUp, characterID, placeDepth, placeMatrix);
	}
}