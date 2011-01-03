package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class SoundStreamBlockParser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final byte[] streamSoundData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength());

		return new SoundStreamBlockTag(header, streamSoundData);
	}

}
