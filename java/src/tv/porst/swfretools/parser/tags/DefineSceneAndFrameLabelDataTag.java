package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.FrameLabel;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneName;

/**
 * Represents a DefineSceneAndFrameLabelData tag.
 * 
 * @author sp
 *
 */
public final class DefineSceneAndFrameLabelDataTag extends Tag {

	/**
	 * Number of scenes.
	 */
	private final EncodedU32 sceneCount;

	/**
	 * List of scene names.
	 */
	private final List<SceneName> sceneNames;

	/**
	 * Number of frame labels.
	 */
	private final EncodedU32 frameLabelCount;

	/**
	 * List of frame labels.
	 */
	private final List<FrameLabel> frameLabels;

	/**
	 * Creates a new StartSound2 tag object.
	 * 
	 * @param header Tag header.
	 * @param sceneCount Number of scenes.
	 * @param sceneNames List of scene names.
	 * @param frameLabelCount Number of frame labels.
	 * @param frameLabels List of frame labels.
	 */
	public DefineSceneAndFrameLabelDataTag(final RecordHeader header,
			final EncodedU32 sceneCount, final List<SceneName> sceneNames, final EncodedU32 frameLabelCount,
			final List<FrameLabel> frameLabels) {
		super(header);

		this.sceneCount = sceneCount;
		this.sceneNames = new ArrayList<SceneName>(sceneNames);
		this.frameLabelCount = frameLabelCount;
		this.frameLabels = new ArrayList<FrameLabel>(frameLabels);
	}

	/**
	 * Returns the number of frame labels.
	 * 
	 * @return The number of frame labels.
	 */
	public EncodedU32 getFrameLabelCount() {
		return frameLabelCount;
	}

	/**
	 * Returns the list of frame labels.
	 * 
	 * @return The list of frame labels.
	 */
	public List<FrameLabel> getFrameLabels() {
		return frameLabels;
	}

	/**
	 * Returns the number of scenes.
	 * 
	 * @return The number of scenes.
	 */
	public EncodedU32 getSceneCount() {
		return sceneCount;
	}

	/**
	 * Returns the list of scene names.
	 * 
	 * @return The list of scene names.
	 */
	public List<SceneName> getSceneNames() {
		return sceneNames;
	}
}