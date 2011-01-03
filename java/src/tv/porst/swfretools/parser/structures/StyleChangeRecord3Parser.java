package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;

public class StyleChangeRecord3Parser {

	public static StyleChangeRecord3 parse(final BinaryParser parser, final int fillBits, final int lineBits) {

		final Flag typeFlag = parser.readFlag();
		final Flag stateNewStyles = parser.readFlag();
		final Flag stateLineStyle = parser.readFlag();
		final Flag stateFillStyle1 = parser.readFlag();
		final Flag stateFillStyle0 = parser.readFlag();
		final Flag stateMoveTo = parser.readFlag();
		final int moveBits = stateMoveTo.value() ? parser.readBits(5) : 0;
		final int moveDeltaX = stateMoveTo.value() ? parser.readBits(moveBits) : 0;
		final int moveDeltaY = stateMoveTo.value() ? parser.readBits(moveBits) : 0;
		final int fillStyle0 = stateFillStyle0.value() ? parser.readBits(fillBits) : 0;
		final int fillStyle1 = stateFillStyle1.value() ? parser.readBits(fillBits) : 0;
		final int lineStyle = stateLineStyle.value() ? parser.readBits(lineBits) : 0;
		final FillStyle3Array fillStyles = stateNewStyles.value() ? FillStyle3ArrayParser.parse(parser) : null;
		final LineStyle3Array lineStyles = stateNewStyles.value() ? LineStyle3ArrayParser.parse(parser) : null;
		final int numFillBits = stateNewStyles.value() ? parser.readBits(4) : 0;
		final int numLineBits = stateNewStyles.value() ? parser.readBits(4) : 0;

		return new StyleChangeRecord3(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle0,
				stateFillStyle1, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}

}
