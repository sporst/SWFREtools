package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FIXED8 structure.
 * 
 * @author sp
 *
 */
public final class Fixed8 implements IFileElement {

	/**
	 * Integer part of the FIXED8 structure.
	 */
	private final UINT8 integer;

	/**
	 * Decimal part of the FIXED8 structure.
	 */
	private final UINT8 decimal;

	/**
	 * Creates a new FIXED8 object.
	 * 
	 * @param integer Integer part of the FIXED8 structure.
	 * @param decimal Decimal part of the FIXED8 structure.
	 */
	public Fixed8(final UINT8 integer, final UINT8 decimal) {

		this.integer = integer;
		this.decimal = decimal;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(integer, decimal);
	}

	@Override
	public int getBitPosition() {
		return integer.getBitPosition();
	}

	/**
	 * Returns the decimal part of the FIXED8 structure.
	 *
	 * @return The decimal part of the FIXED8 structure.
	 */
	public UINT8 getDecimal() {
		return decimal;
	}

	/**
	 * Returns the integer part of the FIXED8 structure.
	 *
	 * @return The integer part of the FIXED8 structure.
	 */
	public UINT8 getInteger() {
		return integer;
	}

	public int value() {
		return 0;
	}
}