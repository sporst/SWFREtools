package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class CSMTextSettingsParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 textID = parser.readUInt16();
		final int useFlashType = parser.readBits(2);
		final int gridFit = parser.readBits(3);
		final int reserved = parser.readBits(3);
		final float thickness = parser.readFloat();
		final float sharpness = parser.readFloat();
		final UINT8 reserved2 = parser.readUInt8();

		return new CSMTextSettingsTag(header, textID, useFlashType, gridFit, reserved, thickness, sharpness, reserved2);
	}

}
