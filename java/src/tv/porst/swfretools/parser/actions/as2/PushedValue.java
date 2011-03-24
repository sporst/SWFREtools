package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public abstract class PushedValue<T extends IFileElement> implements IFileElement {

	private final UINT8 type;
	private final T value;

	public PushedValue(final UINT8 type, final T value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(type, value);
	}

	@Override
	public int getBitPosition() {
		return type.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getType() {
		return type;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public T getValue() {
		return value;
	}

}
