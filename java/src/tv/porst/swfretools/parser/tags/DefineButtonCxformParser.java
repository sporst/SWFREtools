package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonCxformParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 buttonID = parser.readUInt16();
		final CxForm buttonColorTransform = CxFormParser.parse(parser);

		return new DefineButtonCxformTag(header, buttonID, buttonColorTransform);
	}

}
