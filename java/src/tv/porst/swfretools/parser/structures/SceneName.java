package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.PString;

/**
 * Represents a SceneName structure.
 * 
 * @author sp
 *
 */
public final class SceneName {

	/**
	 * Frame offset of the scene.
	 */
	private final EncodedU32 offset;

	/**
	 * Name of the scene.
	 */
	private final PString name;

	/**
	 * Creates a new SceneName object.
	 * 
	 * @param offset Frame offset of the scene.
	 * @param name Name of the scene.
	 */
	public SceneName(final EncodedU32 offset, final PString name) {

		this.offset = offset;
		this.name = name;

	}

	/**
	 * Returns the name of the scene.
	 *
	 * @return The name of the scene.
	 */
	public PString getName() {
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