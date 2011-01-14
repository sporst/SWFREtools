package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.SBits;

public class Rect {

	private final Bits nBits;
	private final SBits xMin;
	private final SBits xMax;
	private final SBits yMin;
	private final SBits yMax;

	public Rect(final Bits nBits, final SBits xMin2, final SBits xMax2, final SBits yMin2, final SBits yMax2) {
		this.nBits = nBits;
		this.xMin = xMin2;
		this.xMax = xMax2;
		this.yMin = yMin2;
		this.yMax = yMax2;
	}

}
