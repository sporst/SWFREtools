package tv.porst.swfretools.parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Contains code for decompressing the ZLIB-packed part of a SWF file.
 */
public final class SWFDecompressor {

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

		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		final Inflater decompressor = new Inflater();
		decompressor.setInput(strip(fileData));

		final byte[] buffer = new byte[1024];

		int count = 0;

		try {
			do {
				count = decompressor.inflate(buffer);
				output.write(buffer, 0, count);
			} while (count != 0 && !decompressor.finished());
		}
		catch( final DataFormatException dfe )
		{
			dfe.printStackTrace();
		}

		try {
			output.close();
		}
		catch (final IOException e) {
		}

		return output.toByteArray();
	}

	/**
	 * Strips the first 8 bytes of the input array.
	 * 
	 * @param bytes The input array.
	 * 
	 * @return The stripped output array.
	 */
	private static byte[] strip(final byte[] bytes) {

		assert bytes != null : "Bytes array must not be null";
		assert bytes.length >= 8 : "Bytes array must be at least 8 bytes long";

		final byte[] strippedArray = new byte[bytes.length - 8];
		System.arraycopy(bytes, 8, strippedArray, 0, bytes.length - 8);
		return strippedArray;
	}

	/**
	 * Decompresses compressed SWF file data.
	 * 
	 * @param fileData File data to be parsed.
	 * 
	 * @return The decompressed file data that is now ready for parsing.
	 * 
	 * @throws SWFParserException Thrown if decompressing the data failed.
	 */
	public static byte[] decompressData(final byte[] fileData) throws SWFParserException {

		assert fileData != null : "Invalid SWF file data passed to function";

		try {
			return concatPreprocessedData(fileData, decompress(fileData));
		} catch (final IOException e) {
			throw new SWFParserException(0x00001, 0, "Invalid SWF file: Compressed data could not be decompressed");
		}
	}
}