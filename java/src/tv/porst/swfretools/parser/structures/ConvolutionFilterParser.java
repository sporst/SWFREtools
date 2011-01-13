package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.UINT8;

public class ConvolutionFilterParser {

	public static ConvolutionFilter parse(final BinaryParser parser) {

		final UINT8 matrixX = parser.readUInt8();
		final UINT8 matrixY = parser.readUInt8();
		final Float32 divisor = parser.readFloat();
		final Float32 bias = parser.readFloat();
		final Float32[] matrix = new Float32[matrixX.value() * matrixY.value()];

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
