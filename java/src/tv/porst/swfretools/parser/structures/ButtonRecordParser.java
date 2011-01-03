package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;

public class ButtonRecordParser {

	public static ButtonRecord parse(final BinaryParser parser) {
		final int buttonReserved = parser.readBits(2);
		final Flag buttonHasBlendMode = parser.readFlag();
		final Flag buttonHasFilterList = parser.readFlag();
		final Flag buttonStateHitTest = parser.readFlag();
		final Flag buttonStateDown = parser.readFlag();
		final Flag buttonStateOver = parser.readFlag();
		final Flag buttonStateUp = parser.readFlag();
		final UINT16 characterID = parser.readUInt16();
		final UINT16 placeDepth = parser.readUInt16();
		final Matrix placeMatrix = MatrixParser.parse(parser);

		return new ButtonRecord(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver,
				buttonStateUp, characterID, placeDepth, placeMatrix);
	}

}
