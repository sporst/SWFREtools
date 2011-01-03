package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.IParsedINTElement;

public class KerningRecordParser {

	public static KerningRecord parse(final BinaryParser parser, final boolean fontFlagsWideCodes) {

		final IParsedINTElement fontKerningCode1 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final IParsedINTElement fontKerningCode2 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final INT16 fontKerningAdjustment = parser.readInt16();

		return new KerningRecord(fontKerningCode1, fontKerningCode2, fontKerningAdjustment);
	}

}
