package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonTag extends Tag {

	public DefineButtonTag(final RecordHeader header, final UINT16 buttonID,
			final List<ButtonRecord> characters, final List<Action> actions,
			final UINT8 actionEndFlag) {
		super(header);
	}

}
