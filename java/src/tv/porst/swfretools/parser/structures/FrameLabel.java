package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FrameLabel structure.
 * 
 * @author sp
 *
 */
public final class FrameLabel implements IFileElement {

	/**
	 * Offset for scene.
	 */
	private final EncodedU32 offset;

	/**
	 * Name of scene.
	 */
	private final AsciiString name;

	/**
	 * Creates a new RGBA object.
	 * 
	 * @param offset Offset for scene.
	 * @param name Name of scene.
	 */
	public FrameLabel(final EncodedU32 offset, final AsciiString name) {

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
	 * Returns the name of scene.
	 *
	 * @return The name of scene.
	 */
	public AsciiString getName() {
		return name;
	}

	/**
	 * Returns the offset for scene.
	 *
	 * @return The offset for scene.
	 */
	public EncodedU32 getOffset() {
		return offset;
	}
}