package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class LineStyle4Parser {

	public static LineStyle4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 width = parser.readUInt16();
		final Bits startCapStyle = parser.readBits(2);
		final Bits joinStyle = parser.readBits(2);
		final Flag hasFillFlag = parser.readFlag();
		final Flag noHScaleFlag = parser.readFlag();
		final Flag noVScaleFlag = parser.readFlag();
		final Flag pixelHintingFlag = parser.readFlag();
		final Bits reserved = parser.readBits(5);
		final Flag noClose = parser.readFlag();
		final Bits endCapStyle = parser.readBits(2);
		final UINT16 miterLimitFactor = joinStyle.value() == 2 ? parser.readUInt16() : null;
		final RGBA color = !hasFillFlag.value() ? RGBAParser.parse(parser, fieldName + "::Color") : null;
		final FillStyle3 fillType = hasFillFlag.value() ? FillStyle3Parser.parse(parser, fieldName + "::FillType") : null;

		return new LineStyle4(width, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose,
				endCapStyle, miterLimitFactor, color, fillType);
	}
}
