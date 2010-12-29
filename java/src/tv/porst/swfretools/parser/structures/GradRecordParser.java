package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class GradRecordParser {

	public static GradRecord parse(final BinaryParser parser) {
		final int ratio = parser.readUInt8();
		final RGB color = RGBParser.parse(parser);

		return new GradRecord(ratio, color);
	}

}
