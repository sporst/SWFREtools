package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MorphFillStyleParser {

	public static MorphFillStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 fillStyleType = parser.readUInt8();
		final int fillStyleTypeValue = fillStyleType.value();
		final RGB startColor = fillStyleTypeValue == 0x00 ? RGBParser.parse(parser, fieldName + "::StartColor") : null;
		final RGB endColor = fillStyleTypeValue == 0x00 ? RGBParser.parse(parser, fieldName + "::EndColor") : null;
		final Matrix startGradientMatrix = fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 ? MatrixParser.parse(parser, fieldName + "::StartGradientMatrix") : null;
		final Matrix endGradientMatrix = fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 ? MatrixParser.parse(parser, fieldName + "::EndGradientMatrix") : null;
		final MorphGradient gradient = fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 ? MorphGradientParser.parse(parser, fieldName + "::Gradient") : null;
		final UINT16 bitmapId = fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? parser.readUInt16() : null;
		final Matrix startBitmapMatrix= fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? MatrixParser.parse(parser, fieldName + "::StartBitmapMatrix") : null;
		final Matrix endBitmapMatrix= fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43 ? MatrixParser.parse(parser, fieldName + "::EndBitmapMatrix") : null;

		return new MorphFillStyle(fillStyleType, startColor, endColor, startGradientMatrix, endGradientMatrix, gradient, bitmapId, startBitmapMatrix, endBitmapMatrix);
	}

}
