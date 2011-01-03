package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class FillStyle3Parser {

	private static IGradient getGradient(final BinaryParser parser, final int fillStyleType) {

		if (fillStyleType == 0x10 || fillStyleType == 0x12) {
			return Gradient3Parser.parse(parser);
		}
		else if (fillStyleType == 0x13) {
			return FocalGradientParser.parse(parser);
		}
		else {
			return null;
		}
	}

	public static FillStyle3 parse(final BinaryParser parser) {

		final UINT8 fillStyleType = parser.readUInt8();
		final int fillStyleTypeValue = fillStyleType.value();
		final RGBA color = fillStyleTypeValue == 0x00 ? RGBAParser.parse(parser) : null;
		final Matrix gradientMatrix = fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 || fillStyleTypeValue == 0x13 ? MatrixParser.parse(parser) : null;
		final IGradient gradient = getGradient(parser, fillStyleTypeValue);
		final UINT16 bitmapId = fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? parser.readUInt16() : null;
		final Matrix bitmapMatrix= fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? MatrixParser.parse(parser) : null;

		return new FillStyle3(fillStyleType, color, gradientMatrix, gradient, bitmapId, bitmapMatrix);

	}

}
