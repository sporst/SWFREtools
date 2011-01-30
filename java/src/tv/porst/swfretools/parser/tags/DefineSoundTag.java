package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineSound tag.
 * 
 * @author sp
 *
 */
public final class DefineSoundTag extends Tag {

	/**
	 * ID for this sound.
	 */
	private final UINT16 soundId;

	/**
	 * Format of sound data.
	 */
	private final UBits soundFormat;

	/**
	 * The sampling rate.
	 */
	private final UBits soundRate;

	/**
	 * Size of each sample.
	 */
	private final UBits soundSize;

	/**
	 * Sound type flag.
	 */
	private final UBits soundType;

	/**
	 * Number of samples.
	 */
	private final UINT32 soundSampleCount;

	/**
	 * The sound data.
	 */
	private final ByteArray soundData;

	/**
	 * Creates a new DefineSound tag object.
	 * 
	 * @param header Tag header.
	 * @param soundId ID for this sound.
	 * @param soundFormat Format of sound data.
	 * @param soundRate The sampling rate.
	 * @param soundSize Size of each sample.
	 * @param soundType Sound type flag.
	 * @param soundSampleCount Number of samples.
	 * @param soundData The sound data.
	 */
	public DefineSoundTag(final RecordHeader header, final UINT16 soundId, final UBits soundFormat,
			final UBits soundRate, final UBits soundSize, final UBits soundType, final UINT32 soundSampleCount,
			final ByteArray soundData) {
		super(header);

		this.soundId = soundId;
		this.soundFormat = soundFormat;
		this.soundRate = soundRate;
		this.soundSize = soundSize;
		this.soundType = soundType;
		this.soundSampleCount = soundSampleCount;
		this.soundData = soundData;
	}

	/**
	 * Returns the sound data.
	 * 
	 * @return The sound data.
	 */
	public ByteArray getSoundData() {
		return soundData;
	}

	/**
	 * Returns the Format of sound data.
	 * 
	 * @return The format of sound data.
	 */
	public UBits getSoundFormat() {
		return soundFormat;
	}

	/**
	 * Returns the ID for this sound.
	 * 
	 * @return The ID for this sound.
	 */
	public UINT16 getSoundId() {
		return soundId;
	}

	/**
	 * Returns the sampling rate.
	 * 
	 * @return The sampling rate.
	 */
	public UBits getSoundRate() {
		return soundRate;
	}

	/**
	 * Returns the number of samples.
	 * 
	 * @return The number of samples.
	 */
	public UINT32 getSoundSampleCount() {
		return soundSampleCount;
	}

	/**
	 * Returns the size of each sample.
	 * 
	 * @return The size of each sample.
	 */
	public UBits getSoundSize() {
		return soundSize;
	}

	/**
	 * Returns the sound type flag.
	 * 
	 * @return The sound type flag.
	 */
	public UBits getSoundType() {
		return soundType;
	}
}