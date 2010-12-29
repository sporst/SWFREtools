package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class LineStyle4ArrayParser {

	public static LineStyle4Array parse(final BinaryParser parser) {

		final int lineStyleCount = parser.readUInt8();
		final int lineStyleCountExtended = lineStyleCount == 0xFF ? parser.readUInt16() : 0;

		final int normalizedCount = lineStyleCount == 0xFF ? lineStyleCountExtended : lineStyleCount;

		final List<LineStyle4> lineStyles = new ArrayList<LineStyle4>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyle4Parser.parse(parser));
		}

		return new LineStyle4Array(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
