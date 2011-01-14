package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class StyleChangeRecord implements ShapeRecord {

	public StyleChangeRecord(final Flag typeFlag, final Flag stateNewStyles,
			final Flag stateLineStyle, final Flag stateFillStyle0,
			final Flag stateFillStyle1, final Flag stateMoveTo, final Bits moveBits,
			final Bits moveDeltaX, final Bits moveDeltaY, final Bits fillStyle0, final Bits fillStyle1,
			final Bits lineStyle, final FillStyleArray fillStyles,
			final LineStyleArray lineStyles, final Bits numFillBits, final Bits numLineBits) {
		// TODO Auto-generated constructor stub
	}

}
