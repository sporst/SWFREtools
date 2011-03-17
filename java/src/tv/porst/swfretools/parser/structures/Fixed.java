package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FIXED structure.
 * 
 * @author sp
 *
 */
public final class Fixed implements IFileElement {

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

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(integer, decimal);
	}

	@Override
	public int getBitPosition() {
		return integer.getBitPosition();
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