package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.Matrix;

public class ButtonRecord2 {

	public ButtonRecord2(final int buttonReserved, final boolean buttonHasBlendMode,
			final boolean buttonHasFilterList, final boolean buttonStateHitTest,
			final boolean buttonStateDown, final boolean buttonStateOver,
			final boolean buttonStateUp, final UINT16 characterID, final UINT16 placeDepth,
			final Matrix placeMatrix, final CxFormWithAlpha colorTransform,
			final FilterList filterList, final UINT8 blendMode) {
		// TODO Auto-generated constructor stub
	}

}
