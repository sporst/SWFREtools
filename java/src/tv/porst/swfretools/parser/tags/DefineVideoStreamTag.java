package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineVideoStream tag.
 */
public final class DefineVideoStreamTag extends Tag {

	/**
	 * ID for this video character.
	 */
	private final UINT16 characterId;

	/**
	 * Number of VideoFrame tags that makes up this stream.
	 */
	private final UINT16 numFrames;

	/**
	 * Width in pixels.
	 */
	private final UINT16 width;

	/**
	 * Height in pixels.
	 */
	private final UINT16 height;

	/**
	 * Reserved video flags.
	 */
	private final UBits videoFlagsReserved;

	/**
	 * Deblocking video flags.
	 */
	private final UBits videoFlagsDeblocking;

	/**
	 * Smoothing flag.
	 */
	private final Flag videoFlagsSmoothing;

	/**
	 * Codec ID.
	 */
	private final UINT8 codecId;

	/**
	 * Creates a new DefineVideoStream tag object.
	 * 
	 * @param header Tag header.
	 * @param characterId ID for this video character.
	 * @param numFrames Number of VideoFrame tags that makes up this stream.
	 * @param width Width in pixels.
	 * @param height Height in pixels.
	 * @param videoFlagsReserved Reserved video flags.
	 * @param videoFlagsDeblocking Deblocking video flags.
	 * @param videoFlagsSmoothing Smoothing flag.
	 * @param codecId Codec ID.
	 */
	public DefineVideoStreamTag(final RecordHeader header, final UINT16 characterId,
			final UINT16 numFrames, final UINT16 width, final UINT16 height, final UBits videoFlagsReserved,
			final UBits videoFlagsDeblocking, final Flag videoFlagsSmoothing, final UINT8 codecId) {
		super(header);

		this.characterId = characterId;
		this.numFrames = numFrames;
		this.width = width;
		this.height = height;
		this.videoFlagsReserved = videoFlagsReserved;
		this.videoFlagsDeblocking = videoFlagsDeblocking;
		this.videoFlagsSmoothing = videoFlagsSmoothing;
		this.codecId = codecId;
	}

	/**
	 * Returns the ID for this video character.
	 * 
	 * @return The ID for this video character.
	 */
	public UINT16 getCharacterId() {
		return characterId;
	}

	/**
	 * Returns the codec ID.
	 * 
	 * @return The codec ID.
	 */
	public UINT8 getCodecId() {
		return codecId;
	}

	/**
	 * Returns the height in pixels.
	 * 
	 * @return The height in pixels.
	 */
	public UINT16 getHeight() {
		return height;
	}

	/**
	 * Returns the number of VideoFrame tags that makes up this stream.
	 * 
	 * @return The number of VideoFrame tags that makes up this stream.
	 */
	public UINT16 getNumFrames() {
		return numFrames;
	}

	/**
	 * Returns the deblocking video flags.
	 * 
	 * @return The deblocking video flags.
	 */
	public UBits getVideoFlagsDeblocking() {
		return videoFlagsDeblocking;
	}

	/**
	 * Returns the reserved video flags.
	 * 
	 * @return The reserved video flags.
	 */
	public UBits getVideoFlagsReserved() {
		return videoFlagsReserved;
	}

	/**
	 * Returns the smoothing flag.
	 * 
	 * @return The smoothing flag.
	 */
	public Flag getVideoFlagsSmoothing() {
		return videoFlagsSmoothing;
	}

	/**
	 * Returns the width in pixels.
	 * 
	 * @return The width in pixels.
	 */
	public UINT16 getWidth() {
		return width;
	}
}