package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class MatrixParser {

	public static Matrix parse(final BinaryParser parser) {

		final int hasScale = parser.readBits(1);
		final int nScaleBits = hasScale == 1 ? parser.readBits(5) : 0;
		final int scaleX = hasScale == 1 ? parser.readBits(nScaleBits) : 0;
		final int scaleY = hasScale == 1 ? parser.readBits(nScaleBits) : 0;
		final int hasRotate = parser.readBits(1);
		final int nRotateBits = hasRotate == 1 ? parser.readBits(5) : 0;
		final int rotateSkew0 = hasRotate == 1 ? parser.readBits(nRotateBits) : 0;
		final int rotateSkew1 = hasRotate == 1 ? parser.readBits(nRotateBits) : 0;
		final int nTranslateBits = parser.readBits(5);
		final int translateX = parser.readBits(nTranslateBits);
		final int translateY = parser.readBits(nTranslateBits);

		return new Matrix(hasScale, nScaleBits, scaleX, scaleY, hasRotate, nRotateBits, rotateSkew0, rotateSkew1, nTranslateBits, translateX, translateY);
	}

}
