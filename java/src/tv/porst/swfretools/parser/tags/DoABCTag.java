package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a DoABC tag.
 */
public final class DoABCTag extends Tag {

	/**
	 * Action flags.
	 */
	private final UINT32 flags;

	/**
	 * Name assigned to the bytecode.
	 */
	private final AsciiString name;

	/**
	 * Code defined by the tag.
	 */
	private final AS3Data abcData;

	/**
	 * Creates a new DoABC tag.
	 * 
	 * @param header Tag header.
	 * @param flags Action flags.
	 * @param name Name assigned to the bytecode.
	 * @param abcData Code defined by the tag.
	 */
	public DoABCTag(final RecordHeader header, final UINT32 flags, final AsciiString name, final AS3Data abcData) {
		super(header);

		this.flags = flags;
		this.name = name;
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

	/**
	 * Returns the action flags.
	 *
	 * @return The action flags.
	 */
	public UINT32 getFlags() {
		return flags;
	}

	/**
	 * Returns the name assigned to the bytecode.
	 *
	 * @return The name assigned to the bytecode.
	 */
	public AsciiString getName() {
		return name;
	}
}