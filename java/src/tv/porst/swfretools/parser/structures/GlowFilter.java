package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;

/**
 * Represents a GlowFilter structure.
 * 
 * @author sp
 *
 */
public final class GlowFilter implements IFileElement {

	/**
	 * Color of the shadow.
	 */
	private final RGBA glowColor;

	/**
	 * Horizontal blur amount.
	 */
	private final Fixed blurX;

	/**
	 * Vertical blur amount.
	 */
	private final Fixed blurY;

	/**
	 * Strength of the glow.
	 */
	private final Fixed8 strength;

	/**
	 * Inner glow mode.
	 */
	private final Flag innerShadow;

	/**
	 * Knockout mode.
	 */
	private final Flag knockout;

	/**
	 * Composite source.
	 */
	private final Flag compositeSource;

	/**
	 * Number of blur passes.
	 */
	private final UBits passes;

	/**
	 * Creates a new GradientGlowFilter object.
	 * 
	 * @param glowColor Color of the shadow.
	 * @param blurX Horizontal blur amount.
	 * @param blurY Vertical blur amount.
	 * @param strength Strength of the glow.
	 * @param innerShadow Inner glow mode.
	 * @param knockout Knockout mode.
	 * @param compositeSource Composite source.
	 * @param passes Number of blur passes.
	 */
	public GlowFilter(final RGBA glowColor, final Fixed blurX, final Fixed blurY,
			final Fixed8 strength, final Flag innerShadow, final Flag knockout,
			final Flag compositeSource, final UBits passes) {

		this.glowColor = glowColor;
		this.blurX = blurX;
		this.blurY = blurY;
		this.strength = strength;
		this.innerShadow = innerShadow;
		this.knockout = knockout;
		this.compositeSource = compositeSource;
		this.passes = passes;

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

	@Override
	public int getBytePosition() {
		return glowColor.getBytePosition();
	}

	/**
	 * Returns the composite source.
	 *
	 * @return The composite source.
	 */
	public Flag getCompositeSource() {
		return compositeSource;
	}

	/**
	 * Returns the color of the shadow.
	 *
	 * @return The color of the shadow.
	 */
	public RGBA getGlowColor() {
		return glowColor;
	}

	/**
	 * Returns the inner glow mode.
	 *
	 * @return The inner glow mode.
	 */
	public Flag getInnerShadow() {
		return innerShadow;
	}

	/**
	 * Returns the knockout mode.
	 *
	 * @return The knockout mode.
	 */
	public Flag getKnockout() {
		return knockout;
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
	 * Returns the strength of the glow.
	 *
	 * @return The strength of the glow.
	 */
	public Fixed8 getStrength() {
		return strength;
	}
}