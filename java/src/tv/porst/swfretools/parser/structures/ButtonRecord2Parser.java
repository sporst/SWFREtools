package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ButtonRecord2Parser {

	public static ButtonRecord2 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final Bits buttonReserved = parser.readBits(2);
		final Flag buttonHasBlendMode = parser.readFlag();
		final Flag buttonHasFilterList = parser.readFlag();
		final Flag buttonStateHitTest = parser.readFlag();
		final Flag buttonStateDown = parser.readFlag();
		final Flag buttonStateOver = parser.readFlag();
		final Flag buttonStateUp = parser.readFlag();
		final UINT16 characterID = parser.readUInt16();
		final UINT16 placeDepth = parser.readUInt16();
		final Matrix placeMatrix = MatrixParser.parse(parser, fieldName + "::PlaceMatrix");
		final CxFormWithAlpha colorTransform = CxFormWithAlphaParser.parse(parser, fieldName + "::CxFormWithAlpha");
		final FilterList filterList = buttonHasFilterList.value() ? FilterListParser.parse(parser) : null;
		final UINT8 blendMode = buttonHasBlendMode.value() ? parser.readUInt8() : null;

		return new ButtonRecord2(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver,
				buttonStateUp, characterID, placeDepth, placeMatrix,
				colorTransform, filterList, blendMode);
	}

}
