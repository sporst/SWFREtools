package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses StyleChangeRecord structures.
 * 
 * @author sp
 *
 */
public final class StyleChangeRecordParser {

	/**
	 * Parses a StyleChangeRecord structure.
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
	public static StyleChangeRecord parse(final SWFBinaryParser parser, final Bits fillBits, final Bits lineBits, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parseFlag(parser, 0x00006, fieldName + "::TypeFlag");
		final Flag stateNewStyles = parseFlag(parser, 0x00006, fieldName + "::StateNewStyles");
		final Flag stateLineStyle = parseFlag(parser, 0x00006, fieldName + "::StateLineStyle");
		final Flag stateFillStyle1 = parseFlag(parser, 0x00006, fieldName + "::StateFillStyle1");
		final Flag stateFillStyle0 = parseFlag(parser, 0x00006, fieldName + "::StateFillStyle0");
		final Flag stateMoveTo = parseFlag(parser, 0x00006, fieldName + "::StateMoveTo");
		final Bits moveBits = parseBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveBits");
		final Bits moveDeltaX = parseBitsIf(parser, moveBits.value(), 0x00006, stateMoveTo, fieldName + "::MoveDeltaX");
		final Bits moveDeltaY = parseBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveDeltaY");
		final Bits fillStyle0 = parseBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle0, fieldName + "::FillStyle0");
		final Bits fillStyle1 = parseBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle1, fieldName + "::FillStyle1");
		final Bits lineStyle = parseBitsIf(parser, lineBits.value(), 0x00006, stateLineStyle, fieldName + "::LineStyle");
		final FillStyleArray fillStyles = FillStyleArrayParser.parseIf(parser, stateNewStyles, fieldName + "::FillStyles");
		final LineStyleArray lineStyles = LineStyleArrayParser.parseIf(parser, stateNewStyles, fieldName + "LineStyles");
		final Bits numFillBits = parseBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumLineBits");

		return new StyleChangeRecord(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle1,
				stateFillStyle0, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}
}