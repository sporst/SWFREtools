package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;
import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.ButtonRecordParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonParser {

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {
		final UINT16 buttonID = parser.readUInt16();

		final List<ButtonRecord> characters = new ArrayList<ButtonRecord>();

		do
		{
			if (parser.peekUInt8() == 0) {
				break;
			}

			characters.add(ButtonRecordParser.parse(parser, String.format("Characters[%d]", characters.size())));

		} while (true);

		final int actionRecordSize = header.getNormalizedLength() - parser.getBytePosition() - 1;

		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		final UINT8 actionEndFlag = parser.readUInt8();

		return new DefineButtonTag(header, buttonID, characters, actions, actionEndFlag);
	}

}
