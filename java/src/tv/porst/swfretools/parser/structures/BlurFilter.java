package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a BlurFilter structure.
 * 
 * @author sp
 *
 */
public final class BlurFilter implements IFileElement {

	/**
	 * Horizontal blur amount.
	 */
	private final Fixed blurX;

	/**
	 * Vertical blur amount.
	 */
	private final Fixed blurY;

	/**
	 * Number of blur passes.
	 */
	private final UBits passes;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Creates a new FocalGradient object.
	 * 
	 * @param blurX Horizontal blur amount.
	 * @param blurY Vertical blur amount.
	 * @param passes Number of blur passes.
	 * @param reserved Reserved bits.
	 */
	public BlurFilter(final Fixed blurX, final Fixed blurY, final UBits passes, final UBits reserved) {

		this.blurX = blurX;
		this.blurY = blurY;
		this.passes = passes;
		this.reserved = reserved;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(blurX, blurY, passes, reserved);
	}

	@Override
	public int getBitPosition() {
		return blurX.getBitPosition();
	}

	/**
	 * Returns the horizontal blur amount.
	 *
	 * @return The horizontal blur amount.
	 */
	public Fixed getBlurX() {
		return blurX;
	}

	/**
	 * Returns the vertical blur amount.
	 *
	 * @return The vertical blur amount.
	 */
	public Fixed getBlurY() {
		return blurY;
	}

	/**
	 * Returns the number of blur passes.
	 *
	 * @return The number of blur passes.
	 */
	public UBits getPasses() {
		return passes;
	}

	/**
	 * Returns the reserved bits.
	 *
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}
}