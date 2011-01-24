package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.UINT8;

/**
 * Represents a Filter structure.
 * 
 * @author sp
 *
 */
public final class Filter {

	/**
	 * Filter ID.
	 */
	private final UINT8 filterId;

	/**
	 * Drop shadow filter.
	 */
	private final DropShadowFilter dropShadowFilter;

	/**
	 * Blur filter.
	 */
	private final BlurFilter blurFilter;

	/**
	 * Glow filter.
	 */
	private final GlowFilter glowFilter;

	/**
	 * Bevel filter.
	 */
	private final BevelFilter bevelFilter;

	/**
	 * Gradient glow filter.
	 */
	private final GradientGlowFilter gradientGlowFilter;

	/**
	 * Convolution filter.
	 */
	private final ConvolutionFilter convolutionFilter;

	/**
	 * Color matrix filter.
	 */
	private final ColorMatrixFilter colorMatrixFilter;

	/**
	 * Gradient bevel filter.
	 */
	private final GradientBevelFilter gradientBevelFilter;

	/**
	 * Creates a new Filter object.
	 * 
	 * @param filterId Filter ID.
	 * @param dropShadowFilter Drop shadown filter.
	 * @param blurFilter Blur filter.
	 * @param glowFilter Glow filter.
	 * @param bevelFilter Bevel filter.
	 * @param gradientGlowFilter Gradient glow filter.
	 * @param convolutionFilter Convolution filter.
	 * @param colorMatrixFilter Color matrix filter.
	 * @param gradientBevelFilter Gradient bevel filter.
	 */
	public Filter(final UINT8 filterId, final DropShadowFilter dropShadowFilter, final BlurFilter blurFilter,
			final GlowFilter glowFilter, final BevelFilter bevelFilter,
			final GradientGlowFilter gradientGlowFilter,
			final ConvolutionFilter convolutionFilter,
			final ColorMatrixFilter colorMatrixFilter,
			final GradientBevelFilter gradientBevelFilter) {

		this.filterId = filterId;
		this.dropShadowFilter = dropShadowFilter;
		this.blurFilter = blurFilter;
		this.glowFilter = glowFilter;
		this.bevelFilter = bevelFilter;
		this.gradientGlowFilter = gradientGlowFilter;
		this.convolutionFilter = convolutionFilter;
		this.colorMatrixFilter = colorMatrixFilter;
		this.gradientBevelFilter = gradientBevelFilter;
	}

	/**
	 * Returns the bevel filter.
	 *
	 * @return The bevel filter.
	 */
	public BevelFilter getBevelFilter() {
		return bevelFilter;
	}

	/**
	 * Returns the blur filter.
	 *
	 * @return The blur filter.
	 */
	public BlurFilter getBlurFilter() {
		return blurFilter;
	}

	/**
	 * Returns the color matrix filter.
	 *
	 * @return The color matrix filter.
	 */
	public ColorMatrixFilter getColorMatrixFilter() {
		return colorMatrixFilter;
	}

	/**
	 * Returns the convolution filter.
	 *
	 * @return The convolution filter.
	 */
	public ConvolutionFilter getConvolutionFilter() {
		return convolutionFilter;
	}

	/**
	 * Returns the drop shadow filter.
	 *
	 * @return The drop shadow filter.
	 */
	public DropShadowFilter getDropShadowFilter() {
		return dropShadowFilter;
	}

	/**
	 * Returns the filter ID.
	 *
	 * @return The filter ID.
	 */
	public UINT8 getFilterId() {
		return filterId;
	}

	/**
	 * Returns the glow filter.
	 *
	 * @return The glow filter.
	 */
	public GlowFilter getGlowFilter() {
		return glowFilter;
	}

	/**
	 * Returns the gradient bevel filter.
	 *
	 * @return The gradient bevel filter.
	 */
	public GradientBevelFilter getGradientBevelFilter() {
		return gradientBevelFilter;
	}

	/**
	 * Returns the gradient glow filter.
	 *
	 * @return The gradient glow filter.
	 */
	public GradientGlowFilter getGradientGlowFilter() {
		return gradientGlowFilter;
	}
}