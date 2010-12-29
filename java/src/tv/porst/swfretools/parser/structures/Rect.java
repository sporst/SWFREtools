package tv.porst.swfretools.parser.structures;

public class Rect {

	private final int nBits;
	private final int xMin;
	private final int xMax;
	private final int yMin;
	private final int yMax;

	public Rect(final int nBits, final int xMin, final int xMax, final int yMin, final int yMax) {
		this.nBits = nBits;
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}

}
