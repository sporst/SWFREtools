package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.EncodedU32;
import tv.porst.swfretools.parser.structures.FrameLabelList;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SceneNameList;

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
	private final SceneNameList sceneNames;

	/**
	 * Number of frame labels.
	 */
	private final EncodedU32 frameLabelCount;

	/**
	 * List of frame labels.
	 */
	private final FrameLabelList frameLabels;

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
			final EncodedU32 sceneCount, final SceneNameList sceneNames, final EncodedU32 frameLabelCount,
			final FrameLabelList frameLabels) {
		super(header);

		this.sceneCount = sceneCount;
		this.sceneNames = sceneNames;
		this.frameLabelCount = frameLabelCount;
		this.frameLabels = frameLabels;
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
	public FrameLabelList getFrameLabels() {
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
	public SceneNameList getSceneNames() {
		return sceneNames;
	}
}