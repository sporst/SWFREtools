package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;

public class StyleChangeRecordParser {

	public static StyleChangeRecord parse(final BinaryParser parser, final int fillBits, final int lineBits) {

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
		final FillStyleArray fillStyles = stateNewStyles.value() ? FillStyleArrayParser.parse(parser) : null;
		final LineStyleArray lineStyles = stateNewStyles.value() ? LineStyleArrayParser.parse(parser) : null;
		final int numFillBits = stateNewStyles.value() ? parser.readBits(4) : 0;
		final int numLineBits = stateNewStyles.value() ? parser.readBits(4) : 0;

		return new StyleChangeRecord(typeFlag, stateNewStyles, stateLineStyle, stateFillStyle0,
				stateFillStyle1, stateMoveTo, moveBits, moveDeltaX, moveDeltaY, fillStyle0, fillStyle1,
				lineStyle, fillStyles, lineStyles, numFillBits, numLineBits);
	}

}
