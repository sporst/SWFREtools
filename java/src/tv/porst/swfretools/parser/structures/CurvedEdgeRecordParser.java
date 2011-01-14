package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.SBits;

public class CurvedEdgeRecordParser {

	public static CurvedEdgeRecord parse(final BinaryParser parser) {
		final Flag typeFlag = parser.readFlag();
		final Flag straightFlag = parser.readFlag();
		final Bits numBits = parser.readBits(4);
		final SBits controlDeltaX = parser.readSBits(numBits.value() + 2);
		final SBits controlDeltaY = parser.readSBits(numBits.value() + 2);
		final SBits anchorDeltaX = parser.readSBits(numBits.value() + 2);
		final SBits anchorDeltaY = parser.readSBits(numBits.value() + 2);

		return new CurvedEdgeRecord(typeFlag, straightFlag, numBits, controlDeltaX, controlDeltaY, anchorDeltaX, anchorDeltaY);
	}

}
