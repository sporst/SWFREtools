package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class StraightEdgeRecordParser {

	public static StraightEdgeRecord parse(final BinaryParser parser) {
		final boolean typeFlag = parser.readFlag();
		final boolean straightFlag = parser.readFlag();
		final int numBits = parser.readBits(4);
		final boolean generalLineFlag = parser.readFlag();
		final boolean vertLineFlag = generalLineFlag ? parser.readFlag() : false;
		final int deltaX = generalLineFlag || !vertLineFlag ? parser.readSBits(numBits + 2) : 0;
		final int deltaY = generalLineFlag || vertLineFlag ? parser.readSBits(numBits + 2) : 0;

		return new StraightEdgeRecord(typeFlag, straightFlag, numBits, generalLineFlag, vertLineFlag, deltaX, deltaY);
	}

}
