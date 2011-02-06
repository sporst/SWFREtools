package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DoInitAction tag.
 * 
 * @author sp
 *
 */
public final class DoInitActionTag extends Tag {

	/**
	 * Creates a new DoInitAction tag object.
	 * 
	 * @param header Tag header.
	 * @param spriteId Sprite to which these actions apply.
	 */
	public DoInitActionTag(final RecordHeader header, final UINT16 spriteId) {

		super(header);

	}
}