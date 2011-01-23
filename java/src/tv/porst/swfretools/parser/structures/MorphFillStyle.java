package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;

/**
 * Represents a MorphFillStyle structure.
 * 
 * @author sp
 *
 */
public final class MorphFillStyle {

	/**
	 * Type of fill style.
	 */
	private final UINT8 fillStyleType;

	/**
	 * Solid fill color with opacity information for start shape.
	 */
	private final RGBA startColor;

	/**
	 * Solid fill color with opacity information for end shape.
	 */
	private final RGBA endColor;

	/**
	 * Matrix for gradient fill for start shape.
	 */
	private final Matrix startGradientMatrix;

	/**
	 * Matrix for gradient fill for end shape.
	 */
	private final Matrix endGradientMatrix;

	/**
	 * Gradient fill.
	 */
	private final MorphGradient gradient;

	/**
	 * ID of bitmap character for fill.
	 */
	private final UINT16 bitmapId;

	/**
	 * Matrix for bitmap fill for start shape.
	 */
	private final Matrix startBitmapMatrix;

	/**
	 * Matrix for bitmap fill for end shape.
	 */
	private final Matrix endBitmapMatrix;

	/**
	 * Creates a new MorphFillStyleArray object.
	 * 
	 * @param fillStyleType Type of fill style.
	 * @param startColor Solid fill color with opacity information for start shape.
	 * @param endColor Solid fill color with opacity information for start shape.
	 * @param startGradientMatrix Matrix for gradient fill for start shape.
	 * @param endGradientMatrix Matrix for gradient fill for end shape.
	 * @param gradient Gradient fill.
	 * @param bitmapId ID of bitmap character for fill.
	 * @param startBitmapMatrix Matrix for bitmap fill for start shape.
	 * @param endBitmapMatrix Matrix for bitmap fill for end shape.
	 */
	public MorphFillStyle(final UINT8 fillStyleType, final RGBA startColor, final RGBA endColor,
			final Matrix startGradientMatrix, final Matrix endGradientMatrix,
			final MorphGradient gradient, final UINT16 bitmapId, final Matrix startBitmapMatrix,
			final Matrix endBitmapMatrix) {

		this.fillStyleType = fillStyleType;
		this.startColor = startColor;
		this.endColor = endColor;
		this.startGradientMatrix = startGradientMatrix;
		this.endGradientMatrix = endGradientMatrix;
		this.gradient = gradient;
		this.bitmapId = bitmapId;
		this.startBitmapMatrix = startBitmapMatrix;
		this.endBitmapMatrix = endBitmapMatrix;
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
	 * Returns the matrix for bitmap fill for end shape.
	 *
	 * @return The matrix for bitmap fill for end shape.
	 */
	public Matrix getEndBitmapMatrix() {
		return endBitmapMatrix;
	}

	/**
	 * Returns the solid fill color with opacity information for end shape.
	 *
	 * @return The solid fill color with opacity information for end shape.
	 */
	public RGBA getEndColor() {
		return endColor;
	}

	/**
	 * Returns the matrix for gradient fill for end shape.
	 *
	 * @return The matrix for gradient fill for end shape.
	 */
	public Matrix getEndGradientMatrix() {
		return endGradientMatrix;
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
	public MorphGradient getGradient() {
		return gradient;
	}

	/**
	 * Returns the matrix for bitmap fill for start shape.
	 *
	 * @return The matrix for bitmap fill for start shape.
	 */
	public Matrix getStartBitmapMatrix() {
		return startBitmapMatrix;
	}

	/**
	 * Returns the solid fill color with opacity information for start shape.
	 *
	 * @return The solid fill color with opacity information for start shape.
	 */
	public RGBA getStartColor() {
		return startColor;
	}

	/**
	 * Returns the matrix for gradient fill for start shape.
	 *
	 * @return The matrix for gradient fill for start shape.
	 */
	public Matrix getStartGradientMatrix() {
		return startGradientMatrix;
	}
}