package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class LineStyle3Parser {

	public static LineStyle3 parse(final BinaryParser parser) {

		final UINT8 lineStyleType = parser.readUInt8();
		final RGBA color = RGBAParser.parse(parser);

		return new LineStyle3(lineStyleType, color);

	}
}
