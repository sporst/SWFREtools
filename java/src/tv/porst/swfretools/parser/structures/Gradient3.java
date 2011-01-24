package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;

/**
 * Represents a Gradient3 structure.
 * 
 * @author sp
 *
 */
public final class Gradient3 implements IGradient {

	/**
	 * Spread mode.
	 */
	private final Bits spreadMode;

	/**
	 * Interpolation mode.
	 */
	private final Bits interpolationMode;

	/**
	 * Number of gradient records.
	 */
	private final Bits numGradients;

	/**
	 * Gradient records.
	 */
	private final List<GradRecord3> gradientRecords;

	/**
	 * Creates a new Gradient3 object.
	 * 
	 * @param spreadMode Spread mode.
	 * @param interpolationMode Interpolation mode.
	 * @param numGradients Number of gradient records.
	 * @param gradientRecords Gradient records.
	 */
	public Gradient3(final Bits spreadMode, final Bits interpolationMode, final Bits numGradients,
			final List<GradRecord3> gradientRecords) {

		this.spreadMode = spreadMode;
		this.interpolationMode = interpolationMode;
		this.numGradients = numGradients;
		this.gradientRecords = new ArrayList<GradRecord3>(gradientRecords);

	}

	/**
	 * Returns the gradient records.
	 *
	 * @return The gradient records.
	 */
	public List<GradRecord3> getGradientRecords() {
		return gradientRecords;
	}

	/**
	 * Returns the interpolation mode.
	 *
	 * @return The interpolation mode.
	 */
	public Bits getInterpolationMode() {
		return interpolationMode;
	}

	/**
	 * Returns the number of gradient records.
	 *
	 * @return The number of gradient records.
	 */
	public Bits getNumGradients() {
		return numGradients;
	}

	/**
	 * Returns the spread mode.
	 *
	 * @return The spread mode.
	 */
	public Bits getSpreadMode() {
		return spreadMode;
	}
}