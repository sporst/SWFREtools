package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ConvolutionFilterParser {

	public static ConvolutionFilter parse(final BinaryParser parser) {

		final int matrixX = parser.readUInt8();
		final int matrixY = parser.readUInt8();
		final float divisor = parser.readFloat();
		final float bias = parser.readFloat();
		final float[] matrix = new float[matrixX * matrixY];

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
