package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class KerningRecordParser {

	public static KerningRecord parse(final BinaryParser parser, final boolean fontFlagsWideCodes) {

		final int fontKerningCode1 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final int fontKerningCode2 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final int fontKerningAdjustment = parser.readInt16();

		return new KerningRecord(fontKerningCode1, fontKerningCode2, fontKerningAdjustment);
	}

}
