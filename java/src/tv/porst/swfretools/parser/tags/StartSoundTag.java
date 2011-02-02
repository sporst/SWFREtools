package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

/**
 * Represents a StartSound tag.
 * 
 * @author sp
 *
 */
public final class StartSoundTag extends Tag {

	/**
	 * ID of sound character to play.
	 */
	private final UINT16 soundId;

	/**
	 * Sound style information.
	 */
	private final SoundInfo soundInfo;

	/**
	 * Creates a new StartSound tag object.
	 * 
	 * @param header Tag header.
	 * @param soundId ID of sound character to play.
	 * @param soundInfo Sound style information.
	 */
	public StartSoundTag(final RecordHeader header, final UINT16 soundId, final SoundInfo soundInfo) {

		super(header);

		this.soundId = soundId;
		this.soundInfo = soundInfo;
	}

	/**
	 * Returns the ID of sound character to play.
	 * 
	 * @return The ID of sound character to play.
	 */
	public UINT16 getSoundId() {
		return soundId;
	}

	/**
	 * Returns the sound style information.
	 * 
	 * @return The sound style information.
	 */
	public SoundInfo getSoundInfo() {
		return soundInfo;
	}
}