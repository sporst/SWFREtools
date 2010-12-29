package tv.porst.swfretools.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.FileHelpers;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.parser.tags.TagParser;

public final class SWFParser {

	private static byte[] decompress(final byte[] fileData) {

		return fileData;

	}

	public SWFFile parse(final File file) throws IOException, SWFParserException {

		final byte[] fileData = FileHelpers.readFromStream(file);

		if (fileData.length < 8) {
			throw new SWFParserException();
		}

		if ((fileData[0] != 'C' && fileData[0] != 'F') || fileData[1] != 'W' || fileData[2] != 'S') {
			throw new SWFParserException();
		}

		final byte[] decompressedData = fileData[0] == 'F' ? fileData : decompress(fileData);

		final BinaryParser parser = new BinaryParser(decompressedData);

		final byte signature1 = parser.readByte();
		final byte signature2 = parser.readByte();
		final byte signature3 = parser.readByte();

		final byte version = decompressedData[3];

		final long fileLength = parser.readUInt32();

		final Rect frameSize = RectParser.parse(parser);

		final int frameRate = parser.readUInt16();
		final int frameCount = parser.readUInt16();

		final List<Tag> tags = TagParser.parse(parser, version);

		return new SWFFile(signature1, signature2, signature3, version, fileLength, frameSize, frameRate, frameCount, tags);
	}
}
