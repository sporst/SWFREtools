package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

/**
 * Represents a StyleChangeRecord3 structure.
 * 
 * @author sp
 *
 */
public final class StyleChangeRecord3 implements ShapeRecord3 {

	/**
	 * Record type flag.
	 */
	private final Flag typeFlag;

	/**
	 * New styles flag.
	 */
	private final Flag stateNewStyles;

	/**
	 * Line style change flag.
	 */
	private final Flag stateLineStyle;

	/**
	 * Fill style 1 change flag.
	 */
	private final Flag stateFillStyle1;

	/**
	 * Fill style 0 change flag.
	 */
	private final Flag stateFillStyle0;

	/**
	 * Move to flag.
	 */
	private final Flag stateMoveTo;

	/**
	 * Move bit count.
	 */
	private final Bits moveBits;

	/**
	 * Delta X value.
	 */
	private final Bits moveDeltaX;

	/**
	 * Delta Y value.
	 */
	private final Bits moveDeltaY;

	/**
	 * Fill 0 style.
	 */
	private final Bits fillStyle0;

	/**
	 * Fill 1 style.
	 */
	private final Bits fillStyle1;

	/**
	 * Line style.
	 */
	private final Bits lineStyle;

	/**
	 * Array of new fill styles.
	 */
	private final FillStyle3Array fillStyles;

	/**
	 * Array of new line styles.
	 */
	private final LineStyle3Array lineStyles;

	/**
	 * Number of fill index bits for new styles.
	 */
	private final Bits numFillBits;

	/**
	 * Number of line index bits for new styles.
	 */
	private final Bits numLineBits;

	/**
	 * Creates a new TextRecord object.
	 * 
	 * @param typeFlag Record type flag.
	 * @param stateNewStyles New styles flag.
	 * @param stateLineStyle Line style change flag.
	 * @param stateFillStyle0 Fill style 0 change flag.
	 * @param stateFillStyle1 Fill style 1 change flag.
	 * @param stateMoveTo Move to flag.
	 * @param moveBits Move bit count.
	 * @param moveDeltaX Delta X value.
	 * @param moveDeltaY Delta Y value.
	 * @param fillStyle0 Fill 0 style.
	 * @param fillStyle1 Fill 1 style.
	 * @param lineStyle Line style.
	 * @param fillStyles Array of new fill styles.
	 * @param lineStyles Array of new line styles.
	 * @param numFillBits Number of fill index bits for new styles.
	 * @param numLineBits Number of line index bits for new styles.
	 */
	public StyleChangeRecord3(final Flag typeFlag, final Flag stateNewStyles,
			final Flag stateLineStyle, final Flag stateFillStyle1, final Flag stateFillStyle0,
			final Flag stateMoveTo, final Bits moveBits,
			final Bits moveDeltaX, final Bits moveDeltaY, final Bits fillStyle0, final Bits fillStyle1,
			final Bits lineStyle, final FillStyle3Array fillStyles,
			final LineStyle3Array lineStyles, final Bits numFillBits, final Bits numLineBits) {

		this.typeFlag = typeFlag;
		this.stateNewStyles = stateNewStyles;
		this.stateLineStyle = stateLineStyle;
		this.stateFillStyle0 = stateFillStyle0;
		this.stateFillStyle1 = stateFillStyle1;
		this.stateMoveTo = stateMoveTo;
		this.moveBits = moveBits;
		this.moveDeltaX = moveDeltaX;
		this.moveDeltaY = moveDeltaY;
		this.fillStyle0 = fillStyle0;
		this.fillStyle1 = fillStyle1;
		this.lineStyle = lineStyle;
		this.fillStyles = fillStyles;
		this.lineStyles = lineStyles;
		this.numFillBits = numFillBits;
		this.numLineBits = numLineBits;
	}

	/**
	 * Returns the fill 0 style.
	 *
	 * @return The fill 0 style.
	 */
	public Bits getFillStyle0() {
		return fillStyle0;
	}

	/**
	 * Returns the fill 1 style.
	 *
	 * @return The fill 1 style.
	 */
	public Bits getFillStyle1() {
		return fillStyle1;
	}

	/**
	 * Returns the array of new fill styles.
	 *
	 * @return The array of new fill styles.
	 */
	public FillStyle3Array getFillStyles() {
		return fillStyles;
	}

	/**
	 * Returns the line style.
	 *
	 * @return The line style.
	 */
	public Bits getLineStyle() {
		return lineStyle;
	}

	/**
	 * Returns the array of new line styles.
	 *
	 * @return The array of new line styles.
	 */
	public LineStyle3Array getLineStyles() {
		return lineStyles;
	}

	/**
	 * Returns the move bit count.
	 *
	 * @return The move bit count.
	 */
	public Bits getMoveBits() {
		return moveBits;
	}

	/**
	 * Returns the delta X value.
	 *
	 * @return The delta X value.
	 */
	public Bits getMoveDeltaX() {
		return moveDeltaX;
	}

	/**
	 * Returns the delta Y value.
	 *
	 * @return The delta Y value.
	 */
	public Bits getMoveDeltaY() {
		return moveDeltaY;
	}

	/**
	 * Returns the number of fill index bits for new styles.
	 *
	 * @return The number of fill index bits for new styles.
	 */
	public Bits getNumFillBits() {
		return numFillBits;
	}

	/**
	 * Returns the number of line index bits for new styles.
	 *
	 * @return The number of line index bits for new styles.
	 */
	public Bits getNumLineBits() {
		return numLineBits;
	}

	/**
	 * Returns the fill style 0 change flag.
	 *
	 * @return The fill style 0 change flag.
	 */
	public Flag getStateFillStyle0() {
		return stateFillStyle0;
	}

	/**
	 * Returns the fill style 1 change flag.
	 *
	 * @return The fill style 1 change flag.
	 */
	public Flag getStateFillStyle1() {
		return stateFillStyle1;
	}

	/**
	 * Returns the line style change flag.
	 *
	 * @return The line style change flag.
	 */
	public Flag getStateLineStyle() {
		return stateLineStyle;
	}

	/**
	 * Returns the move to flag.
	 *
	 * @return The move to flag.
	 */
	public Flag getStateMoveTo() {
		return stateMoveTo;
	}

	/**
	 * Returns the new styles flag.
	 *
	 * @return The new styles flag.
	 */
	public Flag getStateNewStyles() {
		return stateNewStyles;
	}

	/**
	 * Returns the record type flag.
	 *
	 * @return The record type flag.
	 */
	public Flag getTypeFlag() {
		return typeFlag;
	}
}