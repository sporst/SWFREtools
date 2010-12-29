package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneName;

public class DefineSceneAndFrameLabelDataTag extends Tag {

	public DefineSceneAndFrameLabelDataTag(final RecordHeader header,
			final long sceneCount, final List<SceneName> sceneNames, final long frameLabelCount,
			final List<FrameLabel> frameLabels) {
		super(header);
	}

}
