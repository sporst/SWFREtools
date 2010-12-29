package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class LineStyleArrayParser {

	public static LineStyleArray parse(final BinaryParser parser) {

		final int lineStyleCount = parser.readUInt8();
		final int lineStyleCountExtended = lineStyleCount == 0xFF ? parser.readUInt16() : 0;

		final int normalizedCount = lineStyleCount == 0xFF ? lineStyleCountExtended : lineStyleCount;

		final List<LineStyle> lineStyles = new ArrayList<LineStyle>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyleParser.parse(parser));
		}

		return new LineStyleArray(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
