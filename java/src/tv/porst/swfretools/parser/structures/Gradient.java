package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a Gradient structure.
 * 
 * @author sp
 *
 */
public final class Gradient implements IGradient, IFileElement {

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
	private final GradRecordList gradientRecords;

	/**
	 * Creates a new Gradient object.
	 * 
	 * @param spreadMode Spread mode.
	 * @param interpolationMode Interpolation mode.
	 * @param numGradients Number of gradient records.
	 * @param gradientRecords Gradient records.
	 */
	public Gradient(final UBits spreadMode, final UBits interpolationMode, final UBits numGradients,
			final GradRecordList gradientRecords) {

		this.spreadMode = spreadMode;
		this.interpolationMode = interpolationMode;
		this.numGradients = numGradients;
		this.gradientRecords = gradientRecords;

	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(spreadMode, interpolationMode, numGradients, gradientRecords);
	}

	@Override
	public int getBitPosition() {
		return spreadMode.getBitPosition();
	}

	/**
	 * Returns the gradient records.
	 *
	 * @return The gradient records.
	 */
	public GradRecordList getGradientRecords() {
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