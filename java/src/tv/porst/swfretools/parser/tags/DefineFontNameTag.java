package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontNameTag extends Tag {

	public DefineFontNameTag(final RecordHeader header, final UINT16 fontID, final PString fontName,
			final PString fontCopyright) {
		super(header);
	}

}
