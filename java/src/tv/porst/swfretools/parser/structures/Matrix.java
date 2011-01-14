package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class Matrix {

	private final Flag hasScale;
	private final Bits nScaleBits;
	private final Bits scaleX;
	private final Bits scaleY;
	private final Flag hasRotate;
	private final Bits nRotateBits;
	private final Bits rotateSkew0;
	private final Bits rotateSkew1;
	private final Bits nTranslateBits;
	private final Bits translateX;

	public Matrix(final Flag hasScale2, final Bits nScaleBits, final Bits scaleX, final Bits scaleY,
			final Flag hasRotate, final Bits nRotateBits, final Bits rotateSkew0, final Bits rotateSkew1,
			final Bits nTranslateBits, final Bits translateX, final Bits translateY) {

		this.hasScale = hasScale2;
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
