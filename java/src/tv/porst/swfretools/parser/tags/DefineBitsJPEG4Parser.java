package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG4Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final UINT16 characterId = parser.readUInt16();
		final UINT32 alphaDataOffset = parser.readUInt32();
		final UINT16 deblockParam = parser.readUInt16();
		final byte[] imageData = BinaryParserHelpers.readByteArray(parser, alphaDataOffset.value());
		final byte[] bitmapAlphaData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - alphaDataOffset.value());

		return new DefineBitsJPEG4Tag(header, characterId, alphaDataOffset, deblockParam, imageData, bitmapAlphaData);
	}

}
