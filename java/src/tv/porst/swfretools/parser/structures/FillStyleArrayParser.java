package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class FillStyleArrayParser {

	public static FillStyleArray parse(final BinaryParser parser) {

		final int fillStyleCount = parser.readUInt8();
		final int fillStyleCountExtended = fillStyleCount == 0xFF ? parser.readUInt16() : 0;

		final int normalizedCount = fillStyleCount == 0xFF ? fillStyleCountExtended : fillStyleCount;

		final List<FillStyle> fillStyles = new ArrayList<FillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(FillStyleParser.parse(parser));
		}

		return new FillStyleArray(fillStyleCount, fillStyleCountExtended, fillStyles);
	}

}
