package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineButtonCxformTag extends Tag {

	public DefineButtonCxformTag(final RecordHeader header, final UINT16 buttonID,
			final CxForm buttonColorTransform) {
		super(header);
	}

}
