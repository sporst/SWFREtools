package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseString;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.StringList;

public class ActionConstantPoolParser {

	public static ActionConstantPool parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");
		final UINT16 count = parseUINT16(parser, 0x00006, fieldName + "::Count");

		final List<AsciiString> constants = new ArrayList<AsciiString>();

		for (int i=0;i<count.value();i++) {
			constants.add(parseString(parser, 0x00006, String.format("::ConstantPool[%d]", i)));
		}

		return new ActionConstantPool(actionCode, length, count, new StringList(constants));
	}
}
