package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DefineButtonCxform tag.
 */
public final class DefineButtonCxformTag extends Tag {

	/**
	 * Button ID for this information.
	 */
	private final UINT16 buttonId;

	/**
	 * Character color transform.
	 */
	private final CxForm buttonColorTransform;

	/**
	 * Creates a new DefineButtonCxform tag object.
	 * 
	 * @param header Tag header.
	 * @param buttonId Button ID for this information.
	 * @param buttonColorTransform Character color transform.
	 */
	public DefineButtonCxformTag(final RecordHeader header, final UINT16 buttonId, final CxForm buttonColorTransform) {
		super(header);

		this.buttonId = buttonId;
		this.buttonColorTransform = buttonColorTransform;
	}

	/**
	 * Returns the character color transform.
	 * 
	 * @return The character color transform.
	 */
	public CxForm getButtonColorTransform() {
		return buttonColorTransform;
	}

	/**
	 * Returns the button ID for this information.
	 * 
	 * @return The button ID for this information.
	 */
	public UINT16 getButtonId() {
		return buttonId;
	}
}