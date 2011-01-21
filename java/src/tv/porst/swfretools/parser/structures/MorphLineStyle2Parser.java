package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MorphLineStyle2Parser {

	public static MorphLineStyle2 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT16 startWidth = parser.readUInt16();
		final UINT16 endWidth = parser.readUInt16();
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
		final RGBA startColor = !hasFillFlag.value() ? RGBAParser.parse(parser, fieldName + "::StartColor") : null;
		final RGBA endColor = !hasFillFlag.value() ? RGBAParser.parse(parser, fieldName + "::EndColor") : null;
		final MorphFillStyle fillType = hasFillFlag.value() ? MorphFillStyleParser.parse(parser, fieldName + "::FillType") : null;

		return new MorphLineStyle2(startWidth, endWidth, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose, endCapStyle,
				miterLimitFactor, startColor, endColor, fillType);
	}

}
