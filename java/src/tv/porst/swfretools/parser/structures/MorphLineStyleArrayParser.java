package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MorphLineStyleArrayParser {

	public static MorphLineStyleArray parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 lineStyleCount = parser.readUInt8();
		final UINT16 lineStyleCountExtended = lineStyleCount.value() == 0xFF ? parser.readUInt16() : null;

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<MorphLineStyle> lineStyles = new ArrayList<MorphLineStyle>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(MorphLineStyleParser.parse(parser, String.format(fieldName + "::LineStyles[%d]", i)));
		}

		return new MorphLineStyleArray(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

}
