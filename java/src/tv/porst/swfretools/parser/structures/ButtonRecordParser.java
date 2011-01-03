package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ButtonRecordParser {

	public static ButtonRecord parse(final BinaryParser parser) {
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

		return new ButtonRecord(buttonReserved, buttonHasBlendMode, buttonHasFilterList,
				buttonStateHitTest, buttonStateDown, buttonStateOver,
				buttonStateUp, characterID, placeDepth, placeMatrix);
	}

}
