package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class LineStyle3ArrayParser {

	public static LineStyle3Array parse(final BinaryParser parser) {

		final UINT8 lineStyleCount = parser.readUInt8();
		final UINT16 lineStyleCountExtended = lineStyleCount.value() == 0xFF ? parser.readUInt16() : null;

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<LineStyle3> lineStyles = new ArrayList<LineStyle3>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyle3Parser.parse(parser));
		}

		return new LineStyle3Array(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
