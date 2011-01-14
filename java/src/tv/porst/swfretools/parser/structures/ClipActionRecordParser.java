package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.actions.ActionRecordParser;

public class ClipActionRecordParser {

	public static ClipActionRecord parse(final BinaryParser parser, final int version) {

		final ClipEventFlags eventFlags = ClipEventFlagsParser.parse(parser, version);
		final UINT32 actionRecordSize = parser.readUInt32();
		final UINT8 keyCode = eventFlags.getClipEventKeyPress().value() ? parser.readUInt8() : null;
		final List<Action> actions = ActionRecordParser.parse(parser, actionRecordSize.value());

		return new ClipActionRecord(eventFlags, actionRecordSize, keyCode, actions);

	}

}
