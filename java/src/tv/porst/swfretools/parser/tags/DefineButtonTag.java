package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.actions.Action;
import tv.porst.swfretools.parser.structures.ButtonRecord;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonTag extends Tag {

	public DefineButtonTag(final RecordHeader header, final int buttonID,
			final List<ButtonRecord> characters, final List<Action> actions,
			final int actionEndFlag) {
		super(header);
	}

}
