package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonCxformParser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 buttonID = parser.readUInt16();
		final CxForm buttonColorTransform = CxFormParser.parse(parser, "ButtonColorTransform");

		return new DefineButtonCxformTag(header, buttonID, buttonColorTransform);
	}

}
