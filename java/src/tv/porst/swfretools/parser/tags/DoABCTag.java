package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DoABCTag extends Tag {

	private final UINT32 flags;
	private final AsciiString name;
	private final AS3Data abcData;

	public DoABCTag(final RecordHeader header, final UINT32 flags, final AsciiString name, final AS3Data abcData) {
		super(header);

		this.flags = flags;
		this.name = name;
		this.abcData = abcData;


	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AS3Data getAbcData() {
		return abcData;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT32 getFlags() {
		return flags;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public AsciiString getName() {
		return name;
	}

}
