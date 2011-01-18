package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

/**
 * Represents a DefineButtonSound tag.
 * 
 * @author sp
 *
 */
public final class DefineButtonSoundTag extends Tag {

	/**
	 * The ID of the button these sounds apply to.
	 */
	private final UINT16 buttonId;

	/**
	 * Sound ID for OverUpToIdle.
	 */
	private final UINT16 buttonSoundChar0;

	/**
	 * Sound style for OverUpToIdle.
	 */
	private final SoundInfo buttonSoundInfo0;

	/**
	 * Sound ID for IdleToOverUp.
	 */
	private final UINT16 buttonSoundChar1;

	/**
	 * Sound style for IdleToOverUp.
	 */
	private final SoundInfo buttonSoundInfo1;

	/**
	 * Sound ID for OverUpToOverDown.
	 */
	private final UINT16 buttonSoundChar2;

	/**
	 * Sound style for OverUpOverDown.
	 */
	private final SoundInfo buttonSoundInfo2;

	/**
	 * Sound ID for OverDownToOverUp.
	 */
	private final UINT16 buttonSoundChar3;

	/**
	 * Sound style for OverDownToOverUp.
	 */
	private final SoundInfo buttonSoundInfo3;

	/**
	 * Creates a new ShowFrame tag object.
	 * 
	 * @param header Tag header.
	 * @param buttonId The ID of the button these sounds apply to.
	 * @param buttonSoundChar0 Sound ID for OverUpToIdle.
	 * @param buttonSoundInfo0 Sound style for OverUpToIdle.
	 * @param buttonSoundChar1 Sound ID for IdleToOverUp.
	 * @param buttonSoundInfo1 Sound style for IdleToOverUp.
	 * @param buttonSoundChar2 Sound ID for OverUpToOverDown.
	 * @param buttonSoundInfo2 Sound style for OverUpOverDown.
	 * @param buttonSoundChar3 Sound ID for OverDownToOverUp.
	 * @param buttonSoundInfo3 Sound style for OverDownToOverUp.
	 */
	public DefineButtonSoundTag(final RecordHeader header, final UINT16 buttonId,
			final UINT16 buttonSoundChar0, final SoundInfo buttonSoundInfo0,
			final UINT16 buttonSoundChar1, final SoundInfo buttonSoundInfo1,
			final UINT16 buttonSoundChar2, final SoundInfo buttonSoundInfo2,
			final UINT16 buttonSoundChar3, final SoundInfo buttonSoundInfo3) {

		super(header);

		this.buttonId = buttonId;
		this.buttonSoundChar0 = buttonSoundChar0;
		this.buttonSoundInfo0 = buttonSoundInfo0;
		this.buttonSoundChar1 = buttonSoundChar1;
		this.buttonSoundInfo1 = buttonSoundInfo1;
		this.buttonSoundChar2 = buttonSoundChar2;
		this.buttonSoundInfo2 = buttonSoundInfo2;
		this.buttonSoundChar3 = buttonSoundChar3;
		this.buttonSoundInfo3 = buttonSoundInfo3;
	}

	/**
	 * Returns the ID of the button these sounds apply to.
	 *
	 * @return The ID of the button these sounds apply to.
	 */
	public UINT16 getButtonId() {
		return buttonId;
	}

	/**
	 * Returns the sound ID for OverUpToIdle.
	 *
	 * @return The sound ID for OverUpToIdle.
	 */
	public UINT16 getButtonSoundChar0() {
		return buttonSoundChar0;
	}

	/**
	 * Returns the sound ID for IdleToOverUp.
	 *
	 * @return The sound ID for IdleToOverUp.
	 */
	public UINT16 getButtonSoundChar1() {
		return buttonSoundChar1;
	}

	/**
	 * Returns the sound ID for OverUpToOverDown.
	 *
	 * @return The sound ID for OverUpToOverDown.
	 */
	public UINT16 getButtonSoundChar2() {
		return buttonSoundChar2;
	}

	/**
	 * Returns the sound ID for OverDownToOverUp.
	 *
	 * @return The sound ID for OverDownToOverUp.
	 */
	public UINT16 getButtonSoundChar3() {
		return buttonSoundChar3;
	}

	/**
	 * Returns the sound style for OverUpToIdle.
	 *
	 * @return The sound style for OverUpToIdle.
	 */
	public SoundInfo getButtonSoundInfo0() {
		return buttonSoundInfo0;
	}

	/**
	 * Returns the sound style for IdleToOverUp.
	 *
	 * @return The sound style for IdleToOverUp.
	 */
	public SoundInfo getButtonSoundInfo1() {
		return buttonSoundInfo1;
	}

	/**
	 * Returns the sound style for OverUpOverDown.
	 * 
	 * @return The sound style for OverUpOverDown.
	 */
	public SoundInfo getButtonSoundInfo2() {
		return buttonSoundInfo2;
	}

	/**
	 * Returns the sound style for OverDownToOverUp.
	 * 
	 * @return The sound style for OverDownToOverUp.
	 */
	public SoundInfo getButtonSoundInfo3() {
		return buttonSoundInfo3;
	}
}