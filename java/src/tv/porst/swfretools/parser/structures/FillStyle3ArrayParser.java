package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class FillStyle3ArrayParser {

	public static FillStyle3Array parse(final BinaryParser parser) {

		final int fillStyleCount = parser.readUInt8();
		final int fillStyleCountExtended = fillStyleCount == 0xFF ? parser.readUInt16() : 0;

		final int normalizedCount = fillStyleCount == 0xFF ? fillStyleCountExtended : fillStyleCount;

		final List<FillStyle3> fillStyles = new ArrayList<FillStyle3>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(FillStyle3Parser.parse(parser));
		}

		return new FillStyle3Array(fillStyleCount, fillStyleCountExtended, fillStyles);
	}

}
