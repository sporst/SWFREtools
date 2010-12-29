package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class LineStyle4Parser {

	public static LineStyle4 parse(final BinaryParser parser) {

		final int width = parser.readUInt16();
		final int startCapStyle = parser.readBits(2);
		final int joinStyle = parser.readBits(2);
		final boolean hasFillFlag = parser.readFlag();
		final boolean noHScaleFlag = parser.readFlag();
		final boolean noVScaleFlag = parser.readFlag();
		final boolean pixelHintingFlag = parser.readFlag();
		final int reserved = parser.readBits(5);
		final boolean noClose = parser.readFlag();
		final int endCapStyle = parser.readBits(2);
		final int miterLimitFactor = joinStyle == 2 ? parser.readUInt16() : 0;
		final RGBA color = !hasFillFlag ? RGBAParser.parse(parser) : null;
		final FillStyle3 fillType = hasFillFlag ? FillStyle3Parser.parse(parser) : null;

		return new LineStyle4(width, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose,
				endCapStyle, miterLimitFactor, color, fillType);
	}
}
