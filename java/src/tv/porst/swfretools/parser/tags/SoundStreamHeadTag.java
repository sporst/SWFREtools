package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a SoundStreamHead tag.
 * 
 * @author sp
 *
 */
public final class SoundStreamHeadTag extends Tag {

	/**
	 * Reserved bits.
	 */
	private final Bits reserved;

	/**
	 * Playback sampling rate.
	 */
	private final Bits playbackSoundRate;

	/**
	 * Playback sample size.
	 */
	private final Bits playbackSoundSize;

	/**
	 * Number of playback channels.
	 */
	private final Bits playbackSoundType;

	/**
	 * Format of streaming sound data.
	 */
	private final Bits streamSoundCompression;

	/**
	 * The sampling rate of the streaming sound data.
	 */
	private final Bits streamSoundRate;

	/**
	 * The sample size of the streaming sound data.
	 */
	private final Bits streamSoundSize;

	/**
	 * Number of channels in the streaming sound data.
	 */
	private final Bits streamSoundType;

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
	public SoundStreamHeadTag(final RecordHeader header, final Bits reserved,
			final Bits playbackSoundRate, final Bits playbackSoundSize,
			final Bits playbackSoundType, final Bits streamSoundCompression,
			final Bits streamSoundRate, final Bits streamSoundSize, final Bits streamSoundType,
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
	public Bits getPlaybackSoundRate() {
		return playbackSoundRate;
	}

	/**
	 * Returns the playback sample size.
	 * 
	 * @return The playback sample size.
	 */
	public Bits getPlaybackSoundSize() {
		return playbackSoundSize;
	}

	/**
	 * Returns the number of playback channels.
	 * 
	 * @return The number of playback channels.
	 */
	public Bits getPlaybackSoundType() {
		return playbackSoundType;
	}

	/**
	 * Returns the reserved bits.
	 * 
	 * @return The reserved bits.
	 */
	public Bits getReserved() {
		return reserved;
	}

	/**
	 * Returns the format of streaming sound data.
	 * 
	 * @return The format of streaming sound data.
	 */
	public Bits getStreamSoundCompression() {
		return streamSoundCompression;
	}

	/**
	 * Returns the sampling rate of the streaming sound data.
	 * 
	 * @return The sampling rate of the streaming sound data.
	 */
	public Bits getStreamSoundRate() {
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
	public Bits getStreamSoundSize() {
		return streamSoundSize;
	}

	/**
	 * Returns the number of channels in the streaming sound data.
	 * 
	 * @return The number of channels in the streaming sound data.
	 */
	public Bits getStreamSoundType() {
		return streamSoundType;
	}
}