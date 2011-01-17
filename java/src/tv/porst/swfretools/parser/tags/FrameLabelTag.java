package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a FrameLabel tag.
 * 
 * @author sp
 *
 */
public final class FrameLabelTag extends Tag {

	/**
	 * Label for frame.
	 */
	private final PString name;

	/**
	 * Named anchor identifier.
	 */
	private final UINT8 namedAnchorFlag;

	/**
	 * Creates a new FrameLabel tag object.
	 * 
	 * @param header Tag header.
	 * @param name Label for frame.
	 * @param namedAnchorFlag Named anchor identifier.
	 */
	public FrameLabelTag(final RecordHeader header, final PString name, final UINT8 namedAnchorFlag) {

		super(header);

		this.name = name;
		this.namedAnchorFlag = namedAnchorFlag;
	}

	/**
	 * Returns the label for frame.
	 * 
	 * @return The label for frame.
	 */
	public PString getName() {
		return name;
	}

	/**
	 * Returns the named anchor identifier.
	 * 
	 * @return The named anchor identifier.
	 */
	public UINT8 getNamedAnchorFlag() {
		return namedAnchorFlag;
	}
}