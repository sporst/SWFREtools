package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a SceneName structure.
 * 
 * @author sp
 *
 */
public final class SceneName implements IFileElement {

	/**
	 * Frame offset of the scene.
	 */
	private final EncodedU32 offset;

	/**
	 * Name of the scene.
	 */
	private final AsciiString name;

	/**
	 * Creates a new SceneName object.
	 * 
	 * @param offset Frame offset of the scene.
	 * @param name Name of the scene.
	 */
	public SceneName(final EncodedU32 offset, final AsciiString name) {

		this.offset = offset;
		this.name = name;

	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(offset, name);
	}

	@Override
	public int getBitPosition() {
		return offset.getBitPosition();
	}

	/**
	 * Returns the name of the scene.
	 *
	 * @return The name of the scene.
	 */
	public AsciiString getName() {
		return name;
	}

	/**
	 * Returns the offset of the scene.
	 *
	 * @return The offset of the scene.
	 */
	public EncodedU32 getOffset() {
		return offset;
	}
}