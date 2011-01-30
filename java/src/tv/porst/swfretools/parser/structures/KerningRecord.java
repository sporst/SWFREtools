package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.IParsedINTElement;

/**
 * Represents a KerningRecord structure.
 * 
 * @author sp
 *
 */
public final class KerningRecord {

	/**
	 * Character code of the left character.
	 */
	private final IParsedINTElement fontKerningCode1;

	/**
	 * Character code of the right character.
	 */
	private final IParsedINTElement fontKerningCode2;

	/**
	 * Adjustment relative to left character's advance value.
	 */
	private final INT16 fontKerningAdjustment;

	/**
	 * Creates a new KerningRecord object.
	 * 
	 * @param fontKerningCode1 Character code of the left character.
	 * @param fontKerningCode2 Character code of the right character.
	 * @param fontKerningAdjustment Adjustment relative to left character's advance value.
	 */
	public KerningRecord(final IParsedINTElement fontKerningCode1, final IParsedINTElement fontKerningCode2,
			final INT16 fontKerningAdjustment) {

		this.fontKerningCode1 = fontKerningCode1;
		this.fontKerningCode2 = fontKerningCode2;
		this.fontKerningAdjustment = fontKerningAdjustment;
	}

	/**
	 * Returns the adjustment relative to left character's advance value.
	 *
	 * @return The adjustment relative to left character's advance value.
	 */
	public INT16 getFontKerningAdjustment() {
		return fontKerningAdjustment;
	}

	/**
	 * Returns the character code of the left character.
	 *
	 * @return The aharacter code of the left character.
	 */
	public IParsedINTElement getFontKerningCode1() {
		return fontKerningCode1;
	}

	/**
	 * Returns the character code of the right character.
	 *
	 * @return The character code of the right character.
	 */
	public IParsedINTElement getFontKerningCode2() {
		return fontKerningCode2;
	}
}