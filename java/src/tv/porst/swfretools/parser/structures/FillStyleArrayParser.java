package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class FillStyleArrayParser {

	public static FillStyleArray parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleCount = parser.readUInt8();
		final UINT16 fillStyleCountExtended = fillStyleCount.value() == 0xFF ? parser.readUInt16() : null;

		final int normalizedCount = fillStyleCount.value() == 0xFF ? fillStyleCountExtended.value() : fillStyleCount.value();

		final List<FillStyle> fillStyles = new ArrayList<FillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(FillStyleParser.parse(parser, String.format(fieldName + "::FillStyles[%d]", fillStyles.size())));
		}

		return new FillStyleArray(fillStyleCount, fillStyleCountExtended, fillStyles);
	}

	public static FillStyleArray parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}

}
