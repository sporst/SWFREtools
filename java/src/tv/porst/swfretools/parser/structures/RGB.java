package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents an RGB structure.
 * 
 * @author sp
 *
 */
public final class RGB implements IFileElement {

	/**
	 * Red color value.
	 */
	private final UINT8 red;

	/**
	 * Green color value.
	 */
	private final UINT8 green;

	/**
	 * Blue color value.
	 */
	private final UINT8 blue;

	/**
	 * Creates a new RGB object.
	 * 
	 * @param red Red color value.
	 * @param green Green color value.
	 * @param blue Blue color value.
	 */
	public RGB(final UINT8 red, final UINT8 green, final UINT8 blue) {

		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(red, green, blue);
	}

	@Override
	public int getBitPosition() {
		return red.getBitPosition();
	}

	/**
	 * Returns the blue color value.
	 *
	 * @return The blue color value.
	 */
	public UINT8 getBlue() {
		return blue;
	}

	/**
	 * Returns the green color value.
	 *
	 * @return The green color value.
	 */
	public UINT8 getGreen() {
		return green;
	}

	/**
	 * Returns the red color value.
	 *
	 * @return The red color value.
	 */
	public UINT8 getRed() {
		return red;
	}
}