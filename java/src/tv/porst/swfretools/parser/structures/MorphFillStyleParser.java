package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class MorphFillStyleParser {

	public static MorphFillStyle parse(final BinaryParser parser) {
		final int fillStyleType = parser.readUInt8();
		final RGB startColor = fillStyleType == 0x00 ? RGBParser.parse(parser) : null;
		final RGB endColor = fillStyleType == 0x00 ? RGBParser.parse(parser) : null;
		final Matrix startGradientMatrix = fillStyleType == 0x10 || fillStyleType == 0x12 ? MatrixParser.parse(parser) : null;
		final Matrix endGradientMatrix = fillStyleType == 0x10 || fillStyleType == 0x12 ? MatrixParser.parse(parser) : null;
		final MorphGradient gradient = fillStyleType == 0x10 || fillStyleType == 0x12 ? MorphGradientParser.parse(parser) : null;
		final int bitmapId = fillStyleType >= 0x40 && fillStyleType <= 0x43 ? parser.readUInt16() : 0;
		final Matrix startBitmapMatrix= fillStyleType >= 0x40 && fillStyleType <= 0x43 ? MatrixParser.parse(parser) : null;
		final Matrix endBitmapMatrix= fillStyleType >= 0x40 && fillStyleType <= 0x43 ? MatrixParser.parse(parser) : null;

		return new MorphFillStyle(fillStyleType, startColor, endColor, startGradientMatrix, endGradientMatrix, gradient, bitmapId, startBitmapMatrix, endBitmapMatrix);
	}

}
