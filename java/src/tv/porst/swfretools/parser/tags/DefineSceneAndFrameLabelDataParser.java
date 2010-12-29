package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.EncodedU32Parser;
import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.FrameLabelsParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneName;
import tv.porst.swfretools.parser.structures.SceneNameParser;

public class DefineSceneAndFrameLabelDataParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final long sceneCount = EncodedU32Parser.parse(parser);

		final List<SceneName> sceneNames = new ArrayList<SceneName>();

		for (int i=0;i<sceneCount;i++) {
			sceneNames.add(SceneNameParser.parse(parser));
		}

		final long frameLabelCount = EncodedU32Parser.parse(parser);

		final List<FrameLabel> frameLabels = new ArrayList<FrameLabel>();

		for (int i=0;i<frameLabelCount;i++) {
			frameLabels.add(FrameLabelsParser.parse(parser));
		}

		return new DefineSceneAndFrameLabelDataTag(header, sceneCount, sceneNames, frameLabelCount, frameLabels);
	}

}
