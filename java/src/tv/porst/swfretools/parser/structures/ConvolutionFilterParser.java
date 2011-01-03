package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class ConvolutionFilterParser {

	public static ConvolutionFilter parse(final BinaryParser parser) {

		final UINT8 matrixX = parser.readUInt8();
		final UINT8 matrixY = parser.readUInt8();
		final float divisor = parser.readFloat();
		final float bias = parser.readFloat();
		final float[] matrix = new float[matrixX.value() * matrixY.value()];

		for (int i=0;i<matrix.length;i++) {
			matrix[i] = parser.readFloat();
		}

		final RGBA defaultColor = RGBAParser.parse(parser);

		final int reserved = parser.readBits(6);
		final int clamp = parser.readBits(1);
		final int preserveAlpha = parser.readBits(1);

		return new ConvolutionFilter(matrixX, matrixY, divisor, bias, matrix, defaultColor, reserved, clamp, preserveAlpha);

	}

}
