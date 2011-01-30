package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a SoundInfo structure.
 * 
 * @author sp
 *
 */
public final class SoundInfo {

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Stop the sound now flag.
	 */
	private final Flag syncStop;

	/**
	 * Don't start the sound if already playing flag.
	 */
	private final Flag syncNoMultiple;

	/**
	 * Envelope information flag.
	 */
	private final Flag hasEnvelope;

	/**
	 * Loop information flag.
	 */
	private final Flag hasLoops;

	/**
	 * Out-point information flag.
	 */
	private final Flag hasOutPoint;

	/**
	 * In-point information flag.
	 */
	private final Flag hasInPoint;

	/**
	 * Number of samples to skip at beginning of sound.
	 */
	private final UINT32 inPoint;

	/**
	 * Position in samples of last sample to play.
	 */
	private final UINT32 outPoint;

	/**
	 * Sound loop count.
	 */
	private final UINT16 loopCount;

	/**
	 * Sound Envelope point count.
	 */
	private final UINT8 envPoints;

	/**
	 * Sound Envelope records.
	 */
	private final List<SoundEnvelope> envelopeRecords;

	/**
	 * Creates a new SoundInfo object.
	 * 
	 * @param reserved Reserved bits.
	 * @param syncStop Stop the sound now flag.
	 * @param syncNoMultiple Don't start the sound if already playing flag.
	 * @param hasEnvelope Envelope information flag.
	 * @param hasLoops Loop information flag.
	 * @param hasOutPoint Out-point information flag.
	 * @param hasInPoint In-point information flag.
	 * @param inPoint Number of samples to skip at beginning of sound.
	 * @param outPoint Position in samples of last sample to play.
	 * @param loopCount Sound loop count.
	 * @param envPoints Sound Envelope point count.
	 * @param envelopeRecords Sound Envelope records.
	 */
	public SoundInfo(final UBits reserved, final Flag syncStop, final Flag syncNoMultiple,
			final Flag hasEnvelope, final Flag hasLoops, final Flag hasOutPoint,
			final Flag hasInPoint, final UINT32 inPoint, final UINT32 outPoint, final UINT16 loopCount,
			final UINT8 envPoints, final List<SoundEnvelope> envelopeRecords) {

		this.reserved = reserved;
		this.syncStop = syncStop;
		this.syncNoMultiple = syncNoMultiple;
		this.hasEnvelope = hasEnvelope;
		this.hasLoops = hasLoops;
		this.hasOutPoint = hasOutPoint;
		this.hasInPoint = hasInPoint;
		this.outPoint = outPoint;
		this.inPoint = inPoint;
		this.loopCount = loopCount;
		this.envPoints = envPoints;
		this.envelopeRecords = new ArrayList<SoundEnvelope>(envelopeRecords);
	}

	/**
	 * Returns the sound Envelope records.
	 *
	 * @return The sound Envelope records.
	 */
	public List<SoundEnvelope> getEnvelopeRecords() {
		return new ArrayList<SoundEnvelope>(envelopeRecords);
	}

	/**
	 * Returns the Sound Envelope point count.
	 *
	 * @return The Sound Envelope point count.
	 */
	public UINT8 getEnvPoints() {
		return envPoints;
	}

	/**
	 * Returns the envelope information flag.
	 *
	 * @return The envelope information flag.
	 */
	public Flag getHasEnvelope() {
		return hasEnvelope;
	}

	/**
	 * Returns the in-point information flag.
	 *
	 * @return The in-point information flag.
	 */
	public Flag getHasInPoint() {
		return hasInPoint;
	}

	/**
	 * Returns the loop information flag.
	 *
	 * @return The loop information flag.
	 */
	public Flag getHasLoops() {
		return hasLoops;
	}

	/**
	 * Returns the out-point information flag.
	 *
	 * @return The out-point information flag.
	 */
	public Flag getHasOutPoint() {
		return hasOutPoint;
	}

	/**
	 * Returns the number of samples to skip at beginning of sound.
	 *
	 * @return The number of samples to skip at beginning of sound.
	 */
	public UINT32 getInPoint() {
		return inPoint;
	}

	/**
	 * Returns the sound loop count.
	 *
	 * @return The sound loop count.
	 */
	public UINT16 getLoopCount() {
		return loopCount;
	}

	/**
	 * Returns the position in samples of last sample to play.
	 *
	 * @return The position in samples of last sample to play.
	 */
	public UINT32 getOutPoint() {
		return outPoint;
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
	 * Returns the don't start the sound if already playing flag.
	 *
	 * @return The don't start the sound if already playing flag.
	 */
	public Flag getSyncNoMultiple() {
		return syncNoMultiple;
	}

	/**
	 * Returns the stop the sound now flag.
	 *
	 * @return The stop the sound now flag.
	 */
	public Flag getSyncStop() {
		return syncStop;
	}
}