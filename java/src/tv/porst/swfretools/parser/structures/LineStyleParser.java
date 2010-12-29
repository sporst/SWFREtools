package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class LineStyleParser {

	public static LineStyle parse(final BinaryParser parser) {

		final int lineStyleType = parser.readUInt8();
		final RGB color = RGBParser.parse(parser);

		return new LineStyle(lineStyleType, color);

	}
}
