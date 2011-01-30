package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

/**
 * Represents a FillStyle3 structure.
 * 
 * @author sp
 *
 */
public final class FillStyle3 {

	/**
	 * Type of fill style.
	 */
	private final UINT8 fillStyleType;

	/**
	 * Solid fill color.
	 */
	private final RGBA color;

	/**
	 * Matrix for gradient fill.
	 */
	private final Matrix gradientMatrix;

	/**
	 * Gradient fill.
	 */
	private final IGradient gradient;

	/**
	 * ID of bitmap character for fill.
	 */
	private final UINT16 bitmapId;

	/**
	 * Matrix for bitmap fill.
	 */
	private final Matrix bitmapMatrix;

	/**
	 * Creates a new FillStyle3 object.
	 * 
	 * @param fillStyleType Type of fill style.
	 * @param color Solid fill color.
	 * @param gradientMatrix Matrix for gradient fill.
	 * @param gradient Gradient fill.
	 * @param bitmapId ID of bitmap character for fill.
	 * @param bitmapMatrix Matrix for bitmap fill.
	 */
	public FillStyle3(final UINT8 fillStyleType, final RGBA color, final Matrix gradientMatrix,
			final IGradient gradient, final UINT16 bitmapId, final Matrix bitmapMatrix) {

		this.fillStyleType = fillStyleType;
		this.color = color;
		this.gradientMatrix = gradientMatrix;
		this.gradient = gradient;
		this.bitmapId = bitmapId;
		this.bitmapMatrix = bitmapMatrix;
	}

	/**
	 * Returns the ID of bitmap character for fill.
	 *
	 * @return The ID of bitmap character for fill.
	 */
	public UINT16 getBitmapId() {
		return bitmapId;
	}

	/**
	 * Returns the matrix for bitmap fill.
	 *
	 * @return The matrix for bitmap fill.
	 */
	public Matrix getBitmapMatrix() {
		return bitmapMatrix;
	}

	/**
	 * Returns the solid fill color.
	 *
	 * @return The solid fill color.
	 */
	public RGBA getColor() {
		return color;
	}

	/**
	 * Returns the type of fill style.
	 *
	 * @return The type of fill style.
	 */
	public UINT8 getFillStyleType() {
		return fillStyleType;
	}

	/**
	 * Returns the gradient fill.
	 *
	 * @return The gradient fill.
	 */
	public IGradient getGradient() {
		return gradient;
	}

	/**
	 * Returns the matrix for gradient fill.
	 *
	 * @return The matrix for gradient fill.
	 */
	public Matrix getGradientMatrix() {
		return gradientMatrix;
	}
}