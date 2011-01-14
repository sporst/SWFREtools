package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBitsIf;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class StyleChangeRecordParser {

	public static StyleChangeRecord parse(final SWFBinaryParser parser, final Bits fillBits, final Bits lineBits, final String fieldName) throws SWFParserException {

		final Flag typeFlag = parser.readFlag();
		final Flag stateNewStyles = parser.readFlag();
		final Flag stateLineStyle = parser.readFlag();
		final Flag stateFillStyle1 = parser.readFlag();
		final Flag stateFillStyle0 = parser.readFlag();
		final Flag stateMoveTo = parser.readFlag();
		final Bits moveBits = parseBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveBits");
		final Bits moveDeltaX = parseBitsIf(parser, moveBits.value(), 0x00006, stateMoveTo, fieldName + "::MoveDeltaX");
		final Bits moveDeltaY = parseBitsIf(parser, 5, 0x00006, stateMoveTo, fieldName + "::MoveDeltaY");
		final Bits fillStyle0 = parseBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle0, fieldName + "::FillStyle0");
		final Bits fillStyle1 = parseBitsIf(parser, fillBits.value(), 0x00006, stateFillStyle1, fieldName + "::FillStyle1");
		final Bits lineStyle = parseBitsIf(parser, lineBits.value(), 0x00006, stateLineStyle, fieldName + "::LineStyle");
		final FillStyleArray fillStyles = stateNewStyles.value() ? FillStyleArrayParser.parse(parser, fieldName + "::FillStyles") : null;
		final LineStyleArray lineStyles = stateNewStyles.value() ? LineStyleArrayParser.parse(parser) : null;
		final Bits numFillBits = parseBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumFillBits");
		final Bits numLineBits = parseBitsIf(parser, 4, 0x00006, stateNewStyles, fieldName + "::NumLineBits");

		return new StyleChangeRecord(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle0,
				stateFillStyle1, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}

}
