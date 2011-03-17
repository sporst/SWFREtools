package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a Matrix structure.
 * 
 * @author sp
 *
 */
public final class Matrix implements IFileElement {

	/**
	 * Has scale values if set.
	 */
	private final Flag hasScale;

	/**
	 * Bits in each scale value field.
	 */
	private final UBits nScaleBits;

	/**
	 * X scale value.
	 */
	private final UBits scaleX;

	/**
	 * Y scale value.
	 */
	private final UBits scaleY;

	/**
	 * Has rotate and skew values if set.
	 */
	private final Flag hasRotate;

	/**
	 * Bits in each rotate value field.
	 */
	private final UBits nRotateBits;

	/**
	 * First rotate and skew value.
	 */
	private final UBits rotateSkew0;

	/**
	 * Second rotate and skew value.
	 */
	private final UBits rotateSkew1;

	/**
	 * Bits in each translate value field.
	 */
	private final UBits nTranslateBits;

	/**
	 * X translate value in twips.
	 */
	private final UBits translateX;

	/**
	 * Y translate value in twips.
	 */
	private final UBits translateY;

	/**
	 * Creates a new Matrix object.
	 * 
	 * @param hasScale Has scale values if set.
	 * @param nScaleBits Bits in each scale value field.
	 * @param scaleX X scale value.
	 * @param scaleY Y scale value.
	 * @param hasRotate Has rotate and skew values if set.
	 * @param nRotateBits Bits in each rotate value field.
	 * @param rotateSkew0 First rotate and skew value.
	 * @param rotateSkew1 Second rotate and skew value.
	 * @param nTranslateBits Bits in each translate value field.
	 * @param translateX X translate value in twips.
	 * @param translateY Y translate value in twips.
	 */
	public Matrix(final Flag hasScale, final UBits nScaleBits, final UBits scaleX, final UBits scaleY,
			final Flag hasRotate, final UBits nRotateBits, final UBits rotateSkew0, final UBits rotateSkew1,
			final UBits nTranslateBits, final UBits translateX, final UBits translateY) {

		this.hasScale = hasScale;
		this.nScaleBits = nScaleBits;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.hasRotate = hasRotate;
		this.nRotateBits = nRotateBits;
		this.rotateSkew0 = rotateSkew0;
		this.rotateSkew1 = rotateSkew1;
		this.nTranslateBits = nTranslateBits;
		this.translateX = translateX;
		this.translateY = translateY;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(hasScale, nScaleBits, scaleX, scaleY, hasRotate, nRotateBits,
				rotateSkew0, rotateSkew1, nTranslateBits, translateX, translateY);
	}

	@Override
	public int getBitPosition() {
		return hasScale.getBitPosition();
	}

	/**
	 * Returns whether the matrix has rotate and skew values.
	 *
	 * @return True, if the matrix has rotate and skew values. False, otherwise.
	 */
	public Flag getHasRotate() {
		return hasRotate;
	}

	/**
	 * Returns whether the matrix has scale values.
	 *
	 * @return True, if the matrix has scale values. False, otherwise.
	 */
	public Flag getHasScale() {
		return hasScale;
	}

	/**
	 * Returns the bits in each rotate value field.
	 *
	 * @return The bits in each rotate value field.
	 */
	public UBits getnRotateBits() {
		return nRotateBits;
	}

	/**
	 * Returns the bits in each scale value field.
	 *
	 * @return The bits in each scale value field.
	 */
	public UBits getnScaleBits() {
		return nScaleBits;
	}

	/**
	 * Returns the bits in each translate value field.
	 *
	 * @return The bits in each translate value field.
	 */
	public UBits getnTranslateBits() {
		return nTranslateBits;
	}

	/**
	 * Returns the first rotate and skew value.
	 *
	 * @return The first rotate and skew value.
	 */
	public UBits getRotateSkew0() {
		return rotateSkew0;
	}

	/**
	 * Returns the second rotate and skew value.
	 *
	 * @return The second rotate and skew value.
	 */
	public UBits getRotateSkew1() {
		return rotateSkew1;
	}

	/**
	 * Returns the X scale value.
	 *
	 * @return The X scale value.
	 */
	public UBits getScaleX() {
		return scaleX;
	}

	/**
	 * Returns the Y scale value.
	 *
	 * @return The Y scale value.
	 */
	public UBits getScaleY() {
		return scaleY;
	}

	/**
	 * Returns the X translate value in twips.
	 *
	 * @return The X translate value in twips.
	 */
	public UBits getTranslateX() {
		return translateX;
	}

	/**
	 * Returns the Y translate value in twips.
	 *
	 * @return The Y translate value in twips.
	 */
	public UBits getTranslateY() {
		return translateY;
	}
}