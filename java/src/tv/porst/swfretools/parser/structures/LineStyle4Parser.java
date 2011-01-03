package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;

public class LineStyle4Parser {

	public static LineStyle4 parse(final BinaryParser parser) {

		final UINT16 width = parser.readUInt16();
		final int startCapStyle = parser.readBits(2);
		final int joinStyle = parser.readBits(2);
		final Flag hasFillFlag = parser.readFlag();
		final Flag noHScaleFlag = parser.readFlag();
		final Flag noVScaleFlag = parser.readFlag();
		final Flag pixelHintingFlag = parser.readFlag();
		final int reserved = parser.readBits(5);
		final Flag noClose = parser.readFlag();
		final int endCapStyle = parser.readBits(2);
		final UINT16 miterLimitFactor = joinStyle == 2 ? parser.readUInt16() : null;
		final RGBA color = !hasFillFlag.value() ? RGBAParser.parse(parser) : null;
		final FillStyle3 fillType = hasFillFlag.value() ? FillStyle3Parser.parse(parser) : null;

		return new LineStyle4(width, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose,
				endCapStyle, miterLimitFactor, color, fillType);
	}
}
