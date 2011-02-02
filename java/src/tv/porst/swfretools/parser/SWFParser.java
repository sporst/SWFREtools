package tv.porst.swfretools.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.splib.io.FileHelpers;
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
	 * Concatenates the original uncompressed header of the input file with the decompressed data.
	 * This step is added so that only one parser object is necessary for parsing.
	 * 
	 * @param fileData The file data to parse.
	 * @param decompressedData The decompressed file data.
	 * 
	 * @return The header from the file data prepended in front of the decompressed data.
	 */
	private static byte[] concatPreprocessedData(final byte[] fileData, final byte[] decompressedData) {

		assert fileData != null && fileData.length >= 8 : "Invalid SWF file data passed to function";
		assert decompressedData != null && decompressedData.length >= 8 : "Invalid SWF file data passed to function";

		final byte[] decompressedFile = new byte[8 + decompressedData.length];

		System.arraycopy(fileData, 0, decompressedFile, 0, 8);
		System.arraycopy(decompressedData, 0, decompressedFile, 8, decompressedData.length);

		return decompressedFile;
	}

	/**
	 * Decompresses compressed SWF data.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return The decompressed file data.
	 * 
	 * @throws IOException Thrown if decompressing the data failed.
	 */
	private static byte[] decompress(final byte[] fileData) throws IOException {

		assert fileData != null && fileData.length >= 8 : "Invalid SWF file data passed to function";

		final ByteArrayInputStream inputStream = new ByteArrayInputStream(fileData, 8, fileData.length - 8);
		final InflaterInputStream decompressor = new InflaterInputStream(inputStream);
		final byte[] decompressed = new byte[inputStream.available()];

		decompressor.read(decompressed);

		return decompressed;
	}

	/**
	 * Decompresses compressed SWF file data if necessary.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return The decompressed file data that is now ready for parsing.
	 * 
	 * @throws SWFParserException Thrown if decompressing the data failed.
	 */
	private static byte[] decompressDataIfNecessary(final byte[] fileData) throws SWFParserException {

		assert fileData != null : "Invalid SWF file data passed to function";

		try {
			return isCompressed(fileData) ? decompress(fileData) : fileData;
		} catch (final IOException e) {
			throw new SWFParserException(0x00001, 0, "Invalid SWF file: Compressed data could not be decompressed");
		}
	}

	/**
	 * Verifies the signature of the SWF file to be parsed.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return True, if the file data starts with a Flash signature. False, otherwise.
	 */
	private static boolean hasValidSignature(final byte[] fileData) {

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
	private static boolean isCompressed(final byte[] fileData) {

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
	public SWFFile parse(final File file) throws IOException, SWFParserException {

		if (file == null) {
			throw new IllegalArgumentException("Argument file must not be null");
		}

		final byte[] fileData = FileHelpers.readFile(file);

		if (fileData.length < 8) {
			throw new SWFParserException(0x00002, 0, "Invalid SWF file: File too small");
		}

		if (!hasValidSignature(fileData)) {
			throw new SWFParserException(0x00003, 0, "Invalid SWF file: File signature not found");
		}

		final byte[] parserInputData = concatPreprocessedData(fileData, decompressDataIfNecessary(fileData));

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

		return new SWFFile(signature1, signature2, signature3, version, fileLength, frameSize, frameRate, frameCount, tags.getTags());
	}
}
