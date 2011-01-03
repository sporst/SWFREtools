package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineFontNameParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 fontID = parser.readUInt16();
		final String fontName = parser.readString();
		final String fontCopyright = parser.readString();

		return new DefineFontNameTag(header, fontID, fontName, fontCopyright);
	}

}
