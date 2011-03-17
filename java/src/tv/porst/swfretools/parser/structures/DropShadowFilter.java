package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a DropShadowFilter structure.
 * 
 * @author sp
 *
 */
public final class DropShadowFilter implements IFileElement {

	/**
	 * Color of the shadow.
	 */
	private final RGBA dropShadowColor;

	/**
	 * Horizontal blur amount.
	 */
	private final Fixed blurX;

	/**
	 * Vertical blur amount.
	 */
	private final Fixed blurY;

	/**
	 * Radian angle of the drop shadow.
	 */
	private final Fixed angle;

	/**
	 * Distance of the drop shadow.
	 */
	private final Fixed distance;

	/**
	 * Strength of the drop shadow.
	 */
	private final Fixed8 strength;

	/**
	 * Inner shadow mode.
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
	 * Creates a new DropShadowFilter object.
	 * 
	 * @param dropShadowColor Color of the shadow.
	 * @param blurX Horizontal blur amount.
	 * @param blurY Vertical blur amount.
	 * @param angle Radian angle of the drop shadow.
	 * @param distance Distance of the drop shadow.
	 * @param strength Strength of the drop shadow.
	 * @param innerShadow Inner shadow mode.
	 * @param knockout Knockout mode.
	 * @param compositeSource Composite source.
	 * @param passes Number of blur passes.
	 */
	public DropShadowFilter(final RGBA dropShadowColor, final Fixed blurX, final Fixed blurY,
			final Fixed angle, final Fixed distance, final Fixed8 strength, final Flag innerShadow,
			final Flag knockout, final Flag compositeSource, final UBits passes) {

		this.dropShadowColor = dropShadowColor;
		this.blurX = blurX;
		this.blurY = blurY;
		this.angle = angle;
		this.distance = distance;
		this.strength = strength;
		this.innerShadow = innerShadow;
		this.knockout = knockout;
		this.compositeSource = compositeSource;
		this.passes = passes;
	}

	/**
	 * Returns the radian angle of the drop shadow.
	 *
	 * @return The radian angle of the drop shadow.
	 */
	public Fixed getAngle() {
		return angle;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(dropShadowColor, blurX, blurY, angle, distance, strength,
				innerShadow, knockout, compositeSource, passes);
	}

	@Override
	public int getBitPosition() {
		return dropShadowColor.getBitPosition();
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
	 * Returns the composite source.
	 *
	 * @return The composite source.
	 */
	public Flag getCompositeSource() {
		return compositeSource;
	}

	/**
	 * Returns the distance of the drop shadow.
	 *
	 * @return The distance of the drop shadow.
	 */
	public Fixed getDistance() {
		return distance;
	}

	/**
	 * Returns the color of the shadow.
	 *
	 * @return The color of the shadow.
	 */
	public RGBA getDropShadowColor() {
		return dropShadowColor;
	}

	/**
	 * Returns the inner shadow mode.
	 *
	 * @return The inner shadow mode.
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
	 * Returns the strength of the drop shadow.
	 *
	 * @return The strength of the drop shadow.
	 */
	public Fixed8 getStrength() {
		return strength;
	}
}