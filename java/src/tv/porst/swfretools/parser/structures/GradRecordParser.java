package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class GradRecordParser {

	public static GradRecord parse(final BinaryParser parser) {
		final UINT8 ratio = parser.readUInt8();
		final RGB color = RGBParser.parse(parser);

		return new GradRecord(ratio, color);
	}

}
