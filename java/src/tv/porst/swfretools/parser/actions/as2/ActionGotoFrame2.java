package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ActionGotoFrame2 extends ExtendedAction {

	private final UBits reserved;
	private final Flag sceneBiasFlag;
	private final Flag playFlag;
	private final UINT16 sceneBias;

	public ActionGotoFrame2(final UINT8 actionCode, final UINT16 length, final UBits reserved, final Flag sceneBiasFlag, final Flag playFlag, final UINT16 sceneBias) {
		super(actionCode, length);

		this.reserved = reserved;
		this.sceneBiasFlag = sceneBiasFlag;
		this.playFlag = playFlag;
		this.sceneBias = sceneBias;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(getActionCode(), getLength(), reserved, sceneBiasFlag, playFlag, sceneBias);
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getPlayFlag() {
		return playFlag;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getSceneBias() {
		return sceneBias;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public Flag getSceneBiasFlag() {
		return sceneBiasFlag;
	}

}
