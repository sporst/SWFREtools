package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a FillStyle structure.
 * 
 * @author sp
 *
 */
public final class FillStyle implements IFileElement {

	/**
	 * Type of fill style.
	 */
	private final UINT8 fillStyleType;

	/**
	 * Solid fill color.
	 */
	private final RGB color;

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
	 * Creates a new FillStyle object.
	 * 
	 * @param fillStyleType Type of fill style.
	 * @param color Solid fill color.
	 * @param gradientMatrix Matrix for gradient fill.
	 * @param gradient Gradient fill.
	 * @param bitmapId ID of bitmap character for fill.
	 * @param bitmapMatrix Matrix for bitmap fill.
	 */
	public FillStyle(final UINT8 fillStyleType, final RGB color, final Matrix gradientMatrix,
			final IGradient gradient, final UINT16 bitmapId, final Matrix bitmapMatrix) {

		this.fillStyleType = fillStyleType;
		this.color = color;
		this.gradientMatrix = gradientMatrix;
		this.gradient = gradient;
		this.bitmapId = bitmapId;
		this.bitmapMatrix = bitmapMatrix;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(fillStyleType, color, gradientMatrix, gradient, bitmapId, bitmapMatrix);
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

	@Override
	public int getBitPosition() {
		return fillStyleType.getBitPosition();
	}

	/**
	 * Returns the solid fill color.
	 *
	 * @return The solid fill color.
	 */
	public RGB getColor() {
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