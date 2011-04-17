package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a RemoveObject2 tag.
 */
public final class RemoveObject2Tag extends Tag {

	/**
	 * Depth of character.
	 */
	private final UINT16 depth;

	/**
	 * Creates a new RemoveObject tag object.
	 * 
	 * @param header Tag header.
	 * @param depth Depth of character.
	 */
	public RemoveObject2Tag(final RecordHeader header, final UINT16 depth) {

		super(header);

		SWFParserHelpers.checkNull(depth, "Depth");

		this.depth = depth;
	}

	/**
	 * Returns the depth of character.
	 * 
	 * @return The depth of character.
	 */
	public UINT16 getDepth() {
		return depth;
	}
}