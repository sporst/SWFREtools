package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;

public class ClipActionRecordParser {

	public static ClipActionRecord parse(final BinaryParser parser, final int version) {

		final ClipEventFlags eventFlags = ClipEventFlagsParser.parse(parser, version);
		final long actionRecordSize = parser.readUInt32();
		final int keyCode = eventFlags.getClipEventKeyPress() == 1 ? parser.readUInt8() : 0;
		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize);

		return new ClipActionRecord(eventFlags, actionRecordSize, keyCode, actions);

	}

}
