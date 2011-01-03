package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class MorphFillStyleArrayParser {

	public static MorphFillStyleArray parse(final BinaryParser parser) {
		final UINT8 fillStyleCount = parser.readUInt8();
		final UINT16 fillStyleCountExtended = fillStyleCount.value() == 0xFF ? parser.readUInt16() : null;

		final int normalizedCount = fillStyleCount.value() == 0xFF ? fillStyleCountExtended.value() : fillStyleCount.value();

		final List<MorphFillStyle> fillStyles = new ArrayList<MorphFillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(MorphFillStyleParser.parse(parser));
		}

		return new MorphFillStyleArray(fillStyleCount, fillStyleCountExtended, fillStyles);

	}

}
