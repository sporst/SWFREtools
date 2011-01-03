package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;
import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.ButtonRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int buttonID = parser.readUInt16();

		final List<ButtonRecord> characters = new ArrayList<ButtonRecord>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			characters.add(ButtonRecordParser.parse(parser));

		} while (true);

		final int actionRecordSize = header.getNormalizedLength() - parser.getBytePosition() - 1;

		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		final int actionEndFlag = parser.readUInt8();

		return new DefineButtonTag(header, buttonID, characters, actions, actionEndFlag);
	}

}
