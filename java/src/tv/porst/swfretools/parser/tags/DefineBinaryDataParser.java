package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBinaryDataParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 tag = parser.readUInt16();
		final UINT32 reserved = parser.readUInt32();
		final byte[] data = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - 2 - 4);

		return new DefineBinaryDataTag(header, tag, reserved, data);
	}

}
