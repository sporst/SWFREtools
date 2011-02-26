package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT16;

/**
 * Represents a FIXED structure.
 * 
 * @author sp
 *
 */
public final class Fixed {

	/**
	 * Integer part of the FIXED structure.
	 */
	private final UINT16 integer;

	/**
	 * Decimal part of the FIXED structure.
	 */
	private final UINT16 decimal;

	/**
	 * Creates a new FIXED object.
	 * 
	 * @param integer Integer part of the FIXED structure.
	 * @param decimal Decimal part of the FIXED structure.
	 */
	public Fixed(final UINT16 integer, final UINT16 decimal) {

		this.integer = integer;
		this.decimal = decimal;
	}

	public int getBytePosition() {
		return integer.getBytePosition();
	}

	/**
	 * Returns the decimal part of the FIXED structure.
	 *
	 * @return The decimal part of the FIXED structure.
	 */
	public UINT16 getDecimal() {
		return decimal;
	}

	/**
	 * Returns the integer part of the FIXED structure.
	 *
	 * @return The integer part of the FIXED structure.
	 */
	public UINT16 getInteger() {
		return integer;
	}

	public int value() {
		return 0;
	}
}