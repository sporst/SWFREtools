package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a SoundStreamHead tag.
 */
public final class SoundStreamHeadTag extends Tag {

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Playback sampling rate.
	 */
	private final UBits playbackSoundRate;

	/**
	 * Playback sample size.
	 */
	private final UBits playbackSoundSize;

	/**
	 * Number of playback channels.
	 */
	private final UBits playbackSoundType;

	/**
	 * Format of streaming sound data.
	 */
	private final UBits streamSoundCompression;

	/**
	 * The sampling rate of the streaming sound data.
	 */
	private final UBits streamSoundRate;

	/**
	 * The sample size of the streaming sound data.
	 */
	private final UBits streamSoundSize;

	/**
	 * Number of channels in the streaming sound data.
	 */
	private final UBits streamSoundType;

	/**
	 * Average number of samples in each SoundStreamBlock.
	 */
	private final UINT16 streamSoundSampleCount;

	/**
	 * Latency seek value.
	 */
	private final INT16 latencySeek;

	/**
	 * Creates a new SoundStreamHead tag object.
	 * 
	 * @param header Tag header.
	 * @param reserved Reserved bits.
	 * @param playbackSoundRate Playback sampling rate.
	 * @param playbackSoundSize Playback sample size.
	 * @param playbackSoundType Number of playback channels.
	 * @param streamSoundCompression Format of streaming sound data.
	 * @param streamSoundRate The sampling rate of the streaming sound data.
	 * @param streamSoundSize The sample size of the streaming sound data.
	 * @param streamSoundType Number of channels in the streaming sound data.
	 * @param streamSoundSampleCount Average number of samples in each SoundStreamBlock.
	 * @param latencySeek Latency seek value.
	 */
	public SoundStreamHeadTag(final RecordHeader header, final UBits reserved,
			final UBits playbackSoundRate, final UBits playbackSoundSize,
			final UBits playbackSoundType, final UBits streamSoundCompression,
			final UBits streamSoundRate, final UBits streamSoundSize, final UBits streamSoundType,
			final UINT16 streamSoundSampleCount, final INT16 latencySeek) {
		super(header);

		this.reserved = reserved;
		this.playbackSoundRate = playbackSoundRate;
		this.playbackSoundSize = playbackSoundSize;
		this.playbackSoundType = playbackSoundType;
		this.streamSoundCompression = streamSoundCompression;
		this.streamSoundRate = streamSoundRate;
		this.streamSoundSize = streamSoundSize;
		this.streamSoundType = streamSoundType;
		this.streamSoundSampleCount = streamSoundSampleCount;
		this.latencySeek = latencySeek;
	}

	/**
	 * Returns the latency seek value.
	 * 
	 * @return The latency seek value.
	 */
	public INT16 getLatencySeek() {
		return latencySeek;
	}

	/**
	 * Returns the playback sampling rate.
	 * 
	 * @return The playback sampling rate.
	 */
	public UBits getPlaybackSoundRate() {
		return playbackSoundRate;
	}

	/**
	 * Returns the playback sample size.
	 * 
	 * @return The playback sample size.
	 */
	public UBits getPlaybackSoundSize() {
		return playbackSoundSize;
	}

	/**
	 * Returns the number of playback channels.
	 * 
	 * @return The number of playback channels.
	 */
	public UBits getPlaybackSoundType() {
		return playbackSoundType;
	}

	/**
	 * Returns the reserved bits.
	 * 
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the format of streaming sound data.
	 * 
	 * @return The format of streaming sound data.
	 */
	public UBits getStreamSoundCompression() {
		return streamSoundCompression;
	}

	/**
	 * Returns the sampling rate of the streaming sound data.
	 * 
	 * @return The sampling rate of the streaming sound data.
	 */
	public UBits getStreamSoundRate() {
		return streamSoundRate;
	}

	/**
	 * Returns the average number of samples in each SoundStreamBlock.
	 * 
	 * @return The average number of samples in each SoundStreamBlock.
	 */
	public UINT16 getStreamSoundSampleCount() {
		return streamSoundSampleCount;
	}

	/**
	 * Returns the sample size of the streaming sound data.
	 * 
	 * @return The sample size of the streaming sound data.
	 */
	public UBits getStreamSoundSize() {
		return streamSoundSize;
	}

	/**
	 * Returns the number of channels in the streaming sound data.
	 * 
	 * @return The number of channels in the streaming sound data.
	 */
	public UBits getStreamSoundType() {
		return streamSoundType;
	}
}