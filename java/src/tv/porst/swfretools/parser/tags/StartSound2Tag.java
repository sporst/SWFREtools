package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

/**
 * Represents a StartSound2 tag.
 * 
 * @author sp
 *
 */
public final class StartSound2Tag extends Tag {

	/**
	 * Name of the sound class to play.
	 */
	private final AsciiString soundClassName;

	/**
	 * Sound style information.
	 */
	private final SoundInfo soundInfo;

	/**
	 * Creates a new StartSound2 tag object.
	 * 
	 * @param header Tag header.
	 * @param soundClassName Name of the sound class to play.
	 * @param soundInfo Sound style information.
	 */
	public StartSound2Tag(final RecordHeader header, final AsciiString soundClassName, final SoundInfo soundInfo) {

		super(header);

		SWFParserHelpers.checkNull(soundClassName, "SoundClassName");
		SWFParserHelpers.checkNull(soundInfo, "SoundInfo");

		this.soundClassName = soundClassName;
		this.soundInfo = soundInfo;
	}

	/**
	 * Returns the name of the sound class to play.
	 * 
	 * @return The name of the sound class to play.
	 */
	public AsciiString getSoundClassName() {
		return soundClassName;
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