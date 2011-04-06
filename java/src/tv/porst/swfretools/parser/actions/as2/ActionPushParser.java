package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionPushParser {

	private static PushedValue<?> parsePushedValue(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 type = parseUINT8(parser, 0x00006, fieldName + "::Type");

		switch (type.value()) {
		case 0: return new PushedString(type, SWFParserHelpers.parseString(parser, 0x00006, fieldName + "::String"));
		case 1: return new PushedFloat(type, SWFParserHelpers.parseFloat(parser, 0x00006, fieldName + "::Float"));
		case 2: return new PushedNull(type);
		case 3: return new PushedUndefined(type);
		case 4: return new PushedRegisterNumber(type, parseUINT8(parser, 0x00006, fieldName + "::RegisterNumber"));
		case 5: return new PushedBoolean(type, parseUINT8(parser, 0x00006, fieldName + "::Boolean"));
		case 6: return new PushedDouble(type, SWFParserHelpers.parseDouble(parser, 0x00006, fieldName + "::Double"));
		case 7: return new PushedInteger(type, parseUINT32(parser, 0x00006, fieldName + "::Integer"));
		case 8: return new PushedConstant8(type, parseUINT8(parser, 0x00006, fieldName + "::Constant8"));
		case 9: return new PushedConstant16(type, parseUINT16(parser, 0x00006, fieldName + "::Constant16"));
		default: throw new IllegalStateException("Unknown pushed type");
		}

	}

	public static ActionPush parse(final SWFBinaryParser parser, final UINT8 actionCode, final String fieldName) throws SWFParserException {
		final UINT16 length = parseUINT16(parser, 0x00006, fieldName + "::Length");

		final int end = parser.getBytePosition() + length.value();

		final List<PushedValue<?>> pushedValues = new ArrayList<PushedValue<?>>();

		while (parser.getBytePosition() < end) {
			pushedValues.add(parsePushedValue(parser, fieldName));
		}

		return new ActionPush(actionCode, length, new PushedValueList(pushedValues));
	}
}