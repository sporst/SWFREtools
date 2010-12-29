package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class FillStyleParser {

	private static IGradient getGradient(final BinaryParser parser, final int fillStyleType) {

		if (fillStyleType == 0x10 || fillStyleType == 0x12) {
			return GradientParser.parse(parser);
		}
		else if (fillStyleType == 0x13) {
			return FocalGradientParser.parse(parser);
		}
		else {
			return null;
		}
	}

	public static FillStyle parse(final BinaryParser parser) {

		final int fillStyleType = parser.readUInt8();
		final RGB color = fillStyleType == 0x00 ? RGBParser.parse(parser) : null;
		final Matrix gradientMatrix = fillStyleType == 0x10 || fillStyleType == 0x12 || fillStyleType == 0x13 ? MatrixParser.parse(parser) : null;
		final IGradient gradient = getGradient(parser, fillStyleType);
		final int bitmapId = fillStyleType >= 0x40 && fillStyleType <= 0x43 ? parser.readUInt16() : 0;
		final Matrix bitmapMatrix= fillStyleType >= 0x40 && fillStyleType <= 0x43 ? MatrixParser.parse(parser) : null;

		return new FillStyle(fillStyleType, color, gradientMatrix, gradient, bitmapId, bitmapMatrix);

	}

}
