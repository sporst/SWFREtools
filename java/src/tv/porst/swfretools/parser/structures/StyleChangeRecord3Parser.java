package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses StyleChangeRecord3 structures.
 * 
 * @author sp
 *
 */
public final class StyleChangeRecord3Parser {

	/**
	 * Parses a StyleChangeRecord3 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fillBits
	 * @param lineBits
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static StyleChangeRecord3 parse(final SWFBinaryParser parser, final UBits fillBits, final UBits lineBits, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parseFlag(parser, 0x00006, fieldName + "::TypeFlag");
		final Flag stateNewStyles = parseFlag(parser, 0x00006, fieldName + "::StateNewStyles");
		final Flag stateLineStyle = parseFlag(parser, 0x00006, fieldName + "::StateLineStyle");
		final Flag stateFillStyle1 = parseFlag(parser, 0x00006, fieldName + "::StateFillStyle1");
		final Flag stateFillStyle0 = parseFlag(parser, 0x00006, fieldName + "::StateFillStyle0");
		final Flag stateMoveTo = parseFlag(parser, 0x00006, fieldName + "::StateMoveTo");
		final UBits moveBits = parseUBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveBits");
		final UBits moveDeltaX = parseUBitsIf(parser, moveBits.value(), 0x00006, stateMoveTo, fieldName + "::MoveDeltaX");
		final UBits moveDeltaY = parseUBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveDeltaY");
		final UBits fillStyle0 = parseUBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle0, fieldName + "::FillStyle0");
		final UBits fillStyle1 = parseUBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle1, fieldName + "::FillStyle1");
		final UBits lineStyle = parseUBitsIf(parser, lineBits.value(), 0x00006, stateLineStyle, fieldName + "::LineStyle");
		final FillStyle3Array fillStyles = FillStyle3ArrayParser.parseIf(parser, stateNewStyles, fieldName + "::FillStyles");
		final LineStyle3Array lineStyles = LineStyle3ArrayParser.parseIf(parser, stateNewStyles, fieldName + "::LineStyles");
		final UBits numFillBits = parseUBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumFillBits");
		final UBits numLineBits = parseUBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumLineBits");

		return new StyleChangeRecord3(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle1,
				stateFillStyle0, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}
}