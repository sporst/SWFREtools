package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

/**
 * Represents a Matrix structure.
 * 
 * @author sp
 *
 */
public final class Matrix {

	/**
	 * Has scale values if set.
	 */
	private final Flag hasScale;

	/**
	 * Bits in each scale value field.
	 */
	private final Bits nScaleBits;

	/**
	 * X scale value.
	 */
	private final Bits scaleX;

	/**
	 * Y scale value.
	 */
	private final Bits scaleY;

	/**
	 * Has rotate and skew values if set.
	 */
	private final Flag hasRotate;

	/**
	 * Bits in each rotate value field.
	 */
	private final Bits nRotateBits;

	/**
	 * First rotate and skew value.
	 */
	private final Bits rotateSkew0;

	/**
	 * Second rotate and skew value.
	 */
	private final Bits rotateSkew1;

	/**
	 * Bits in each translate value field.
	 */
	private final Bits nTranslateBits;

	/**
	 * X translate value in twips.
	 */
	private final Bits translateX;

	/**
	 * Y translate value in twips.
	 */
	private final Bits translateY;

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
	public Matrix(final Flag hasScale, final Bits nScaleBits, final Bits scaleX, final Bits scaleY,
			final Flag hasRotate, final Bits nRotateBits, final Bits rotateSkew0, final Bits rotateSkew1,
			final Bits nTranslateBits, final Bits translateX, final Bits translateY) {

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
	public Bits getnRotateBits() {
		return nRotateBits;
	}

	/**
	 * Returns the bits in each scale value field.
	 *
	 * @return The bits in each scale value field.
	 */
	public Bits getnScaleBits() {
		return nScaleBits;
	}

	/**
	 * Returns the bits in each translate value field.
	 *
	 * @return The bits in each translate value field.
	 */
	public Bits getnTranslateBits() {
		return nTranslateBits;
	}

	/**
	 * Returns the first rotate and skew value.
	 *
	 * @return The first rotate and skew value.
	 */
	public Bits getRotateSkew0() {
		return rotateSkew0;
	}

	/**
	 * Returns the second rotate and skew value.
	 *
	 * @return The second rotate and skew value.
	 */
	public Bits getRotateSkew1() {
		return rotateSkew1;
	}

	/**
	 * Returns the X scale value.
	 *
	 * @return The X scale value.
	 */
	public Bits getScaleX() {
		return scaleX;
	}

	/**
	 * Returns the Y scale value.
	 *
	 * @return The Y scale value.
	 */
	public Bits getScaleY() {
		return scaleY;
	}

	/**
	 * Returns the X translate value in twips.
	 *
	 * @return The X translate value in twips.
	 */
	public Bits getTranslateX() {
		return translateX;
	}

	/**
	 * Returns the Y translate value in twips.
	 *
	 * @return The Y translate value in twips.
	 */
	public Bits getTranslateY() {
		return translateY;
	}
}