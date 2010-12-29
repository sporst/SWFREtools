package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ColorMatrixFilterParser {

	public static ColorMatrixFilter parse(final BinaryParser parser) {
		final float[] matrix = new float[20];

		for (int i=0;i<matrix.length;i++) {
			matrix[i] = parser.readFloat();
		}

		return new ColorMatrixFilter(matrix);
	}

}
