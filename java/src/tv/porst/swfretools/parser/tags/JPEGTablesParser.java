package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class JPEGTablesParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final byte[] jpegData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength());

		return new JPEGTablesTag(header, jpegData);
	}

}
