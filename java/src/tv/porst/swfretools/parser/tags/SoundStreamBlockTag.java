package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.ByteArray;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a SoundStreamBlock tag.
 */
public final class SoundStreamBlockTag extends Tag {

	/**
	 * Compressed sound data.
	 */
	private final ByteArray streamSoundData;

	/**
	 * Creates a new SoundStreamBlock tag object.
	 * 
	 * @param header Tag header.
	 * @param streamSoundData Compressed sound data.
	 */
	public SoundStreamBlockTag(final RecordHeader header, final ByteArray streamSoundData) {
		super(header);

		SWFParserHelpers.checkNull(streamSoundData, "StreamSoundData");

		this.streamSoundData = streamSoundData;
	}

	/**
	 * Returns the compressed sound data.
	 * 
	 * @return The compressed sound data.
	 */
	public ByteArray getStreamSoundData() {
		return streamSoundData;
	}
}