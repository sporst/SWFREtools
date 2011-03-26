package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ExceptionInfo implements IFileElement {

	private final EncodedU30 from;

	private final EncodedU30 to;

	private final EncodedU30 target;

	private final EncodedU30 excType;

	private final EncodedU30 varName;

	public ExceptionInfo(final EncodedU30 from, final EncodedU30 to, final EncodedU30 target,
			final EncodedU30 excType, final EncodedU30 varName) {

		this.from = from;
		this.to = to;
		this.target = target;
		this.excType = excType;
		this.varName = varName;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(from, to, target, excType, varName);
	}
	@Override
	public int getBitPosition() {
		return from.getBitPosition();
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getExcType() {
		return excType;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getFrom() {
		return from;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTarget() {
		return target;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTo() {
		return to;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getVarName() {
		return varName;
	}

}
