package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class RectParser {

	public static Rect parse(final BinaryParser parser) {

		final int nBits = parser.readBits(5);

		final int xMin = parser.readBits(nBits);
		final int xMax = parser.readBits(nBits);
		final int yMin = parser.readBits(nBits);
		final int yMax = parser.readBits(nBits);

		return new Rect(nBits, xMin, xMax, yMin, yMax);
	}

}
