package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class LineStyle3ArrayParser {

	public static LineStyle3Array parse(final BinaryParser parser) {

		final int lineStyleCount = parser.readUInt8();
		final int lineStyleCountExtended = lineStyleCount == 0xFF ? parser.readUInt16() : 0;

		final int normalizedCount = lineStyleCount == 0xFF ? lineStyleCountExtended : lineStyleCount;

		final List<LineStyle3> lineStyles = new ArrayList<LineStyle3>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyle3Parser.parse(parser));
		}

		return new LineStyle3Array(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
