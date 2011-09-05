package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a RawABC tag.
 */
public final class RawABCTag extends Tag {

	/**
	 * Code defined by the tag.
	 */
	private final AS3Data abcData;

	/**
	 * Creates a new DoABC tag.
	 * 
	 * @param header Tag header.
	 * @param abcData Code defined by the tag.
	 */
	public RawABCTag(final RecordHeader header, final AS3Data abcData) {
		super(header);

		this.abcData = abcData;
	}

	/**
	 * Returns the code defined by the tag.
	 *
	 * @return The code defined by the tag.
	 */
	public AS3Data getAbcData() {
		return abcData;
	}
}