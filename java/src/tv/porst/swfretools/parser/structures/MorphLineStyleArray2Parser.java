package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class MorphLineStyleArray2Parser {

	public static MorphLineStyleArray2 parse(final BinaryParser parser) {
		final int lineStyleCount = parser.readUInt8();
		final int lineStyleCountExtended = lineStyleCount == 0xFF ? parser.readUInt8() : 0;

		final int normalizedCount = lineStyleCount == 0xFF ? lineStyleCountExtended : lineStyleCount;

		final List<MorphLineStyle2> lineStyles = new ArrayList<MorphLineStyle2>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(MorphLineStyle2Parser.parse(parser));
		}

		return new MorphLineStyleArray2(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
