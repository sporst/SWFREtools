package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DoABCTag extends Tag {

	public DoABCTag(final RecordHeader header, final UINT32 flags, final AsciiString name, final AS3Data abcData) {
		super(header);
	}

}
