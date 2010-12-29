package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class MorphLineStyleArrayParser {

	public static MorphLineStyleArray parse(final BinaryParser parser) {
		final int lineStyleCount = parser.readUInt8();
		final int lineStyleCountExtended = lineStyleCount == 0xFF ? parser.readUInt8() : 0;

		final int normalizedCount = lineStyleCount == 0xFF ? lineStyleCountExtended : lineStyleCount;

		final List<MorphLineStyle> lineStyles = new ArrayList<MorphLineStyle>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(MorphLineStyleParser.parse(parser));
		}

		return new MorphLineStyleArray(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
