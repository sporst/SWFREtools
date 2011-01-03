package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButton2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 buttonID = parser.readUInt16();
		final int reservedFlags = parser.readBits(7);
		final boolean trackAsMenu = parser.readFlag();
		final UINT16 actionOffset = parser.readUInt16();

		final List<ButtonRecord2> characters = new ArrayList<ButtonRecord2>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			characters.add(ButtonRecord2Parser.parse(parser));

		} while (true);

		final int actionRecordSize = header.getNormalizedLength() - parser.getBytePosition() - 1;

		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		final UINT8 actionEndFlag = parser.readUInt8();

		return new DefineButton2Tag(header, buttonID, characters, actions, actionEndFlag);
	}

}
