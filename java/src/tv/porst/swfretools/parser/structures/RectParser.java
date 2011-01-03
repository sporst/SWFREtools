package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

/**
 * Parses SWF Rect structures.
 * 
 * @author sp
 */
public final class RectParser {

	/**
	 * Parses a Rect structure from the current position of the input parser stream.
	 * 
	 * @param parser The parser that parses the input stream.
	 * 
	 * @return The parsed Rect structure.
	 */
	public static Rect parse(final BinaryParser parser) {

		if (parser == null) {
			throw new IllegalArgumentException("Parser argument must not be null");
		}

		final int nBits = parser.readBits(5);

		// It is unclear what happens if nBits is 0. This situation is not specified
		// in the SWF file format reference.

		if (nBits == 0) {
			return new Rect(0, 0, 0, 0, 0);
		}

		final int xMin = parser.readSBits(nBits);
		final int xMax = parser.readSBits(nBits);
		final int yMin = parser.readSBits(nBits);
		final int yMax = parser.readSBits(nBits);

		return new Rect(nBits, xMin, xMax, yMin, yMax);
	}

}
