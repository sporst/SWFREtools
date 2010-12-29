package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class EndShapeRecordParser {

	public static EndShapeRecord parse(final BinaryParser parser) {
		final boolean typeFlag = parser.readFlag();
		final int endOfShape = parser.readBits(5);

		return new EndShapeRecord(typeFlag, endOfShape);
	}

}
