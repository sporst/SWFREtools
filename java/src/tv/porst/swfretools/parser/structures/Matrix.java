package tv.porst.swfretools.parser.structures;

public class Matrix {

	private final int hasScale;
	private final int nScaleBits;
	private final int scaleX;
	private final int scaleY;
	private final int hasRotate;
	private final int nRotateBits;
	private final int rotateSkew0;
	private final int rotateSkew1;
	private final int nTranslateBits;
	private final int translateX;

	public Matrix(final int hasScale, final int nScaleBits, final int scaleX, final int scaleY,
			final int hasRotate, final int nRotateBits, final int rotateSkew0, final int rotateSkew1,
			final int nTranslateBits, final int translateX, final int translateY) {

		this.hasScale = hasScale;
		this.nScaleBits = nScaleBits;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.hasRotate = hasRotate;
		this.nRotateBits = nRotateBits;
		this.rotateSkew0 = rotateSkew0;
		this.rotateSkew1 = rotateSkew1;
		this.nTranslateBits = nTranslateBits;
		this.translateX = translateX;
	}
}
