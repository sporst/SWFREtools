package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBinaryDataParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int tag = parser.readUInt16();
		final long reserved = parser.readUInt32();
		final byte[] data = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - 2 - 4);

		return new DefineBinaryDataTag(header, tag, reserved, data);
	}

}
