package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.CxFormWithAlphaParser;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.FilterListParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;

public class ButtonRecord2Parser {

	public static ButtonRecord2 parse(final BinaryParser parser) {
		final int buttonReserved = parser.readBits(2);
		final boolean buttonHasBlendMode = parser.readFlag();
		final boolean buttonHasFilterList = parser.readFlag();
		final boolean buttonStateHitTest = parser.readFlag();
		final boolean buttonStateDown = parser.readFlag();
		final boolean buttonStateOver = parser.readFlag();
		final boolean buttonStateUp = parser.readFlag();
		final int characterID = parser.readUInt16();
		final int placeDepth = parser.readUInt16();
		final Matrix placeMatrix = MatrixParser.parse(parser);
		final CxFormWithAlpha colorTransform = CxFormWithAlphaParser.parse(parser);
		final FilterList filterList = buttonHasFilterList ? FilterListParser.parse(parser) : null;
		final int blendMode = buttonHasBlendMode ? parser.readUInt8() : 0;

		return new ButtonRecord2(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver,
				buttonStateUp, characterID, placeDepth, placeMatrix,
				colorTransform, filterList, blendMode);
	}

}
