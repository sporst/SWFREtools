package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class MorphFillStyleArrayParser {

	public static MorphFillStyleArray parse(final BinaryParser parser) {
		final int fillStyleCount = parser.readUInt8();
		final int fillStyleCountExtended = fillStyleCount == 0xFF ? parser.readUInt8() : 0;

		final int normalizedCount = fillStyleCount == 0xFF ? fillStyleCountExtended : fillStyleCount;

		final List<MorphFillStyle> fillStyles = new ArrayList<MorphFillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(MorphFillStyleParser.parse(parser));
		}

		return new MorphFillStyleArray(fillStyleCount, fillStyleCountExtended, fillStyles);

	}

}
