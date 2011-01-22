package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT8;

/**
 * Represents a MorphGradient structure.
 * 
 * @author sp
 *
 */
public final class MorphGradient {

	/**
	 * Number of gradients.
	 */
	private final UINT8 numGradients;

	/**
	 * Gradient records.
	 */
	private final List<MorphGradientRecord> gradientRecords;

	/**
	 * Creates a new MorphGradient object.
	 * 
	 * @param numGradients Number of gradients.
	 * @param gradientRecords Gradient records.
	 */
	public MorphGradient(final UINT8 numGradients, final List<MorphGradientRecord> gradientRecords) {

		this.numGradients = numGradients;
		this.gradientRecords = new ArrayList<MorphGradientRecord>(gradientRecords);

	}

	/**
	 * Returns the gradient records.
	 *
	 * @return The gradient records.
	 */
	public List<MorphGradientRecord> getGradientRecords() {
		return new ArrayList<MorphGradientRecord>(gradientRecords);
	}

	/**
	 * Returns the number of gradients.
	 *
	 * @return The number of gradients.
	 */
	public UINT8 getNumGradients() {
		return numGradients;
	}
}