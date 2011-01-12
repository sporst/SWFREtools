package tv.porst.swfretools.parser.tags;

import java.util.List;

import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneName;

public class DefineSceneAndFrameLabelDataTag extends Tag {

	public DefineSceneAndFrameLabelDataTag(final RecordHeader header,
			final EncodedU32 sceneCount, final List<SceneName> sceneNames, final EncodedU32 frameLabelCount,
			final List<FrameLabel> frameLabels) {
		super(header);
	}

}
