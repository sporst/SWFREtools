package tv.porst.swfretools.parser;

import java.io.File;
import java.io.IOException;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.splib.file.FileHelpers;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.tags.TagParser;
import tv.porst.swfretools.parser.tags.TagParserResult;

/**
 * Class for parsing Flash SWF files.
 * 
 * @author sp
 *
 */
public final class SWFParser {

	/**
	 * Verifies the signature of the SWF file to be parsed.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return True, if the file data starts with a Flash signature. False, otherwise.
	 */
	public static boolean hasValidSignature(final byte[] fileData) {

		assert fileData != null && fileData.length >= 3 : "Invalid SWF file data passed to function";

		return (fileData[0] == 'C' || fileData[0] == 'F') && fileData[1] == 'W' && fileData[2] == 'S';
	}

	/**
	 * Determines whether file data to be parsed is compressed or not.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return True, if the file data is compressed. False, otherwise.
	 */
	public static boolean isCompressed(final byte[] fileData) {

		assert fileData != null && fileData.length >= 1 : "Invalid SWF file data passed to function";

		return fileData[0] == 'C';
	}

	/**
	 * Parses a SWF file.
	 * 
	 * @param file The file to parse.
	 * 
	 * @return The parsed SWF file.
	 * 
	 * @throws IOException Thrown if the given file could not be read.
	 * @throws SWFParserException Thrown if the given file could not be parsed.
	 */
	public static SWFFile parse(final File file) throws IOException, SWFParserException {

		if (file == null) {
			throw new IllegalArgumentException("Argument file must not be null");
		}

		final byte[] fileData = FileHelpers.readFile(file);

		return parse(fileData);
	}

	/**
	 * Parses a SWF file.
	 * 
	 * @param bytes Bytes of file to parse.
	 * 
	 * @return The parsed SWF file.
	 * 
	 * @throws IOException Thrown if the given file could not be read.
	 * @throws SWFParserException Thrown if the given file could not be parsed.
	 */
	public static SWFFile parse(final byte[] fileData) throws IOException, SWFParserException {

		if (fileData == null) {
			throw new IllegalArgumentException("Argument file data must not be null");
		}

		if (fileData.length < 8) {
			throw new SWFParserException(0x00002, 0, "Invalid SWF file: File too small");
		}

		if (!hasValidSignature(fileData)) {
			throw new SWFParserException(0x00003, 0, "Invalid SWF file: File signature not found");
		}

		final byte[] parserInputData = isCompressed(fileData) ? SWFDecompressor.decompressData(fileData) : fileData;

		final boolean wasCompressed = parserInputData != fileData;

		final SWFBinaryParser parser = new SWFBinaryParser(parserInputData);

		final UINT8 signature1 = parser.readUInt8();
		final UINT8 signature2 = parser.readUInt8();
		final UINT8 signature3 = parser.readUInt8();

		final UINT8 version = parser.readUInt8();

		final UINT32 fileLength = parser.readUInt32();

		final Rect frameSize = RectParser.parse(parser, "SWFHeader::FrameSize");

		final UINT16 frameRate = parser.readUInt16();
		final UINT16 frameCount = parser.readUInt16();

		final TagParserResult tags = TagParser.parse(parser, version.value());

		return new SWFFile(parserInputData, wasCompressed, signature1, signature2, signature3, version, fileLength, frameSize, frameRate, frameCount, tags.getTags());
	}
}
