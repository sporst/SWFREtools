package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RGB;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a SetBackgroundColor tag.
 * 
 * @author sp
 *
 */
public final class SetBackgroundColorTag extends Tag {

	/**
	 * Color of the display background.
	 */
	private final RGB backgroundColor;

	/**
	 * Creates a new StartSound2 tag object.
	 * 
	 * @param header Tag header.
	 * @param backgroundColor Color of the display background.
	 */
	public SetBackgroundColorTag(final RecordHeader header, final RGB backgroundColor) {
		super(header);

		SWFParserHelpers.checkNull(backgroundColor, "BackgroundColor");

		this.backgroundColor = backgroundColor;
	}

	/**
	 * Returns the color of the display background.
	 * 
	 * @return The color of the display background.
	 */
	public RGB getBackgroundColor() {
		return backgroundColor;
	}
}