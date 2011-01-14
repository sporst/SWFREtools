package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class EndShapeRecordParser {

	public static EndShapeRecord parse(final BinaryParser parser) {
		final Flag typeFlag = parser.readFlag();
		final Bits endOfShape = parser.readBits(5);

		return new EndShapeRecord(typeFlag, endOfShape);
	}

}
