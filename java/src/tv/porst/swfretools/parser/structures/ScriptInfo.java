package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;


public class ScriptInfo implements IFileElement {

	private final EncodedU30 init;

	private final EncodedU30 traitCount;

	private final TraitsInfoList traits;

	public ScriptInfo(final EncodedU30 init, final EncodedU30 traitCount, final TraitsInfoList traits) {
		this.init = init;
		this.traitCount = traitCount;
		this.traits = traits;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(init, traitCount, traits);
	}
	@Override
	public int getBitPosition() {
		return init.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getInit() {
		return init;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTraitCount() {
		return traitCount;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public TraitsInfoList getTraits() {
		return traits;
	}

}
