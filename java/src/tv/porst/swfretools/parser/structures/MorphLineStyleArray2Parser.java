package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

public class MorphLineStyleArray2Parser {

	public static MorphLineStyleArray2 parse(final BinaryParser parser) {
		final UINT8 lineStyleCount = parser.readUInt8();
		final UINT16 lineStyleCountExtended = lineStyleCount.value() == 0xFF ? parser.readUInt16() : null;

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<MorphLineStyle2> lineStyles = new ArrayList<MorphLineStyle2>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(MorphLineStyle2Parser.parse(parser));
		}

		return new MorphLineStyleArray2(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
