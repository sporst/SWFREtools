package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Float32;

public class ColorMatrixFilterParser {

	public static ColorMatrixFilter parse(final BinaryParser parser) {
		final Float32[] matrix = new Float32[20];

		for (int i=0;i<matrix.length;i++) {
			matrix[i] = parser.readFloat();
		}

		return new ColorMatrixFilter(matrix);
	}

}
