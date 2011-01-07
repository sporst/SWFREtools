package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

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

	public static FillStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleType = parser.readUInt8();
		final int fillStyleTypeValue = fillStyleType.value();
		final RGB color = fillStyleTypeValue == 0x00 ? RGBParser.parse(parser) : null;
		final Matrix gradientMatrix = fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 || fillStyleTypeValue == 0x13 ? MatrixParser.parse(parser, fieldName + "::GradientMatrix") : null;
		final IGradient gradient = getGradient(parser, fillStyleTypeValue);
		final UINT16 bitmapId = fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? parser.readUInt16() : null;
		final Matrix bitmapMatrix= fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? MatrixParser.parse(parser, fieldName + "::BitmapMatrix") : null;

		return new FillStyle(fillStyleType, color, gradientMatrix, gradient, bitmapId, bitmapMatrix);

	}

}
