package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;

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
	private final UBits spreadMode;

	/**
	 * Interpolation mode.
	 */
	private final UBits interpolationMode;

	/**
	 * Number of gradient records.
	 */
	private final UBits numGradients;

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
	public Gradient3(final UBits spreadMode, final UBits interpolationMode, final UBits numGradients,
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
	public UBits getInterpolationMode() {
		return interpolationMode;
	}

	/**
	 * Returns the number of gradient records.
	 *
	 * @return The number of gradient records.
	 */
	public UBits getNumGradients() {
		return numGradients;
	}

	/**
	 * Returns the spread mode.
	 *
	 * @return The spread mode.
	 */
	public UBits getSpreadMode() {
		return spreadMode;
	}
}