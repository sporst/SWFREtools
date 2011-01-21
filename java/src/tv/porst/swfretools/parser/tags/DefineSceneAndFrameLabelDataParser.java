package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.EncodedU32Parser;
import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.FrameLabelsParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneName;
import tv.porst.swfretools.parser.structures.SceneNameParser;

/**
 * Class for parsing DefineSceneAndFrameLabelData tags.
 * 
 * @author sp
 */
public final class DefineSceneAndFrameLabelDataParser {

	/**
	 * Parses a DefineSceneAndFrameLabelData tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineSceneAndFrameLabelDataTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final EncodedU32 sceneCount = EncodedU32Parser.parse(parser, "DefineSceneAndFrameLabelData::SceneCount");

		final List<SceneName> sceneNames = new ArrayList<SceneName>();

		for (int i=0;i<sceneCount.value();i++) {
			sceneNames.add(SceneNameParser.parse(parser, String.format("DefineSceneAndFrameLabelData::SceneNames[%d]", i)));
		}

		final EncodedU32 frameLabelCount = EncodedU32Parser.parse(parser, "DefineSceneAndFrameLabelData::FrameLabelCount");

		final List<FrameLabel> frameLabels = new ArrayList<FrameLabel>();

		for (int i=0;i<frameLabelCount.value();i++) {
			frameLabels.add(FrameLabelsParser.parse(parser, String.format("DefineSceneAndFrameLabelData::FrameLabels[%d]", i)));
		}

		return new DefineSceneAndFrameLabelDataTag(header, sceneCount, sceneNames, frameLabelCount, frameLabels);
	}
}