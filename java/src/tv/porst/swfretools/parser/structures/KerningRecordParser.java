package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.IParsedUINTElement;

public class KerningRecordParser {

	public static KerningRecord parse(final BinaryParser parser, final boolean fontFlagsWideCodes) {

		final IParsedUINTElement fontKerningCode1 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final IParsedUINTElement fontKerningCode2 = fontFlagsWideCodes ? parser.readUInt16() : parser.readUInt8();
		final int fontKerningAdjustment = parser.readInt16();

		return new KerningRecord(fontKerningCode1, fontKerningCode2, fontKerningAdjustment);
	}

}
