package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class LineStyleParser {

	public static LineStyle parse(final BinaryParser parser) {

		final UINT8 lineStyleType = parser.readUInt8();
		final RGB color = RGBParser.parse(parser);

		return new LineStyle(lineStyleType, color);

	}
}
