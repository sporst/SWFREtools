package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;

public class StraightEdgeRecordParser {

	public static StraightEdgeRecord parse(final BinaryParser parser) {
		final Flag typeFlag = parser.readFlag();
		final Flag straightFlag = parser.readFlag();
		final int numBits = parser.readBits(4);
		final Flag generalLineFlag = parser.readFlag();
		final Flag vertLineFlag = generalLineFlag.value() ? parser.readFlag() : null;
		final int deltaX = generalLineFlag.value() || !vertLineFlag.value() ? parser.readSBits(numBits + 2) : 0;
		final int deltaY = generalLineFlag.value() || vertLineFlag.value() ? parser.readSBits(numBits + 2) : 0;

		return new StraightEdgeRecord(typeFlag, straightFlag, numBits, generalLineFlag, vertLineFlag, deltaX, deltaY);
	}

}
