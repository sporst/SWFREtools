package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class StyleChangeRecord3Parser {

	public static StyleChangeRecord3 parse(final BinaryParser parser, final int fillBits, final int lineBits) {

		final boolean typeFlag = parser.readFlag();
		final boolean stateNewStyles = parser.readFlag();
		final boolean stateLineStyle = parser.readFlag();
		final boolean stateFillStyle1 = parser.readFlag();
		final boolean stateFillStyle0 = parser.readFlag();
		final boolean stateMoveTo = parser.readFlag();
		final int moveBits = stateMoveTo ? parser.readBits(5) : 0;
		final int moveDeltaX = stateMoveTo ? parser.readBits(moveBits) : 0;
		final int moveDeltaY = stateMoveTo ? parser.readBits(moveBits) : 0;
		final int fillStyle0 = stateFillStyle0 ? parser.readBits(fillBits) : 0;
		final int fillStyle1 = stateFillStyle1 ? parser.readBits(fillBits) : 0;
		final int lineStyle = stateLineStyle ? parser.readBits(lineBits) : 0;
		final FillStyle3Array fillStyles = stateNewStyles ? FillStyle3ArrayParser.parse(parser) : null;
		final LineStyle3Array lineStyles = stateNewStyles ? LineStyle3ArrayParser.parse(parser) : null;
		final int numFillBits = stateNewStyles ? parser.readBits(4) : 0;
		final int numLineBits = stateNewStyles ? parser.readBits(4) : 0;

		return new StyleChangeRecord3(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle0,
				stateFillStyle1, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}

}
