package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

public class StraightEdgeRecordParser {

	public static StraightEdgeRecord parse(final BinaryParser parser) {
		final Flag typeFlag = parser.readFlag();
		final Flag straightFlag = parser.readFlag();
		final int numBits = parser.readBits(4);
		final Flag generalLineFlag = parser.readFlag();
		final Flag vertLineFlag = generalLineFlag.value() ? parser.readFlag() : null;
		final SBits deltaX = generalLineFlag.value() || !vertLineFlag.value() ? parser.readSBits(numBits + 2) : null;
		final SBits deltaY = generalLineFlag.value() || vertLineFlag.value() ? parser.readSBits(numBits + 2) : null;

		return new StraightEdgeRecord(typeFlag, straightFlag, numBits, generalLineFlag, vertLineFlag, deltaX, deltaY);
	}

}
