package tv.porst.swfretools.parser;

import java.util.List;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.BinaryParserHelpers;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.INT16;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT32;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.ByteArray;

/**
 * Contains helper functions for SWF parsing.
 * 
 * @author sp
 *
 */
public final class SWFParserHelpers {

	/**
	 * Throws an exception if less than a given number of bytes remain unparsed in the input stream.
	 * 
	 * @param parser The parser that provides the stream.
	 * @param numberOfBytes The number of remaining bytes to check for.
	 * @param errorCode The error code of the exception to be thrown.
	 * @param fieldName Name of the field to be parsed.
	 * 
	 * @throws SWFParserException Thrown if fewer than the given number of bytes are left in the input stream.
	 */
	private static void throwIf(final SWFBinaryParser parser, final long numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBytesLeft(parser, numberOfBytes)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s (%08X)", fieldName, parser.getBytePosition()));
		}
	}

	/**
	 * Throws an exception if less than a given number of bits remain unparsed in the input stream.
	 * 
	 * @param parser The parser that provides the stream.
	 * @param numberOfBits The number of remaining bits to check for.
	 * @param errorCode The error code of the exception to be thrown.
	 * @param fieldName Name of the field to be parsed.
	 * 
	 * @throws SWFParserException Thrown if fewer than the given number of bits are left in the input stream.
	 */
	private static void throwIfB(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBitsLeft(parser, numberOfBits)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s (%08X)", fieldName, parser.getBytePosition()));
		}
	}

	public static int addBitLengths(final IFileElement ... elements) {

		int length = 0;

		for (final IFileElement element : elements) {

			if (element != null) {
				length += element.getBitLength();
			}
		}

		return length;

	}

	public static int addBitLengths(final List<? extends IFileElement> elements) {

		int length = 0;

		for (final IFileElement element : elements) {

			if (element != null) {
				length += element.getBitLength();
			}
		}

		return length;

	}

	/**
	 * Throws an exception if an argument is null.
	 * 
	 * @param value The value to check.
	 * @param valueName The name of the value to check.
	 */
	public static void checkNull(final Object value, final String valueName) {
		if (value == null) {
			throw new IllegalArgumentException(String.format("%s argument must not be null"));
		}
	}

	/**
	 * Parses a byte array.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBytes Number of bytes to add to the byte array.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed byte array.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static ByteArray parseByteArray(final SWFBinaryParser parser, final long numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, numberOfBytes, errorCode, fieldName);

		return new ByteArray(parser.getBytePosition() * 8 + parser.getBitPosition(), BinaryParserHelpers.readByteArray(parser, (int) numberOfBytes));
	}

	/**
	 * Parses a byte array if a condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBytes Number of bytes to add to the byte array.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the array to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed byte array.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static ByteArray parseByteArrayIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseByteArray(parser, numberOfBytes, errorCode, fieldName) : null;
	}

	/**
	 * Parses a byte array if a condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBytes Number of bytes to add to the byte array.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the array to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed byte array.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static ByteArray parseByteArrayIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {

		checkNull(condition, "Condition");

		return condition.value() ? parseByteArray(parser, numberOfBytes, errorCode, fieldName) : null;
	}

	/**
	 * Parses a flag.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed flag.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Flag parseFlag(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFlag();
	}

	/**
	 * Parses a flag if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the flag to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed flag.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Flag parseFlagIf(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseFlag(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a float.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed float.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Float32 parseFloat(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFloat();
	}

	/**
	 * Parses a short float.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed short float.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Float16 parseFloat16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFloat16();
	}

	/**
	 * Parses a 16 bit integer.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static INT16 parseINT16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT16.BYTE_LENGTH, errorCode, fieldName);
		return parser.readInt16();
	}

	/**
	 * Parses a 16 bit integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static INT16 parseINT16If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseINT16(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 16 bit integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static INT16 parseINT16If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseINT16(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 32 bit integer.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 32 bit integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static INT32 parseINT32(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, INT32.BYTE_LENGTH, errorCode, fieldName);
		return parser.readInt32();
	}

	/**
	 * Parses a signed bit field.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBits Number of bits to parse.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed signed bit field.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Bits parseSBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readSBits(numberOfBits);
	}

	/**
	 * Parses a signed bit field if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBits Number of bits to parse.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed signed bit field.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static Bits parseSBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseSBits(parser, numberOfBits, errorCode, fieldName) : null;
	}

	/**
	 * Parses an ASCII string of a given length.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param length The number of bytes to read.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed ASCII string.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static AsciiString parseString(final SWFBinaryParser parser, final int length, final int errorCode, final String fieldName) throws SWFParserException {
		return parser.readString(length);
	}

	/**
	 * Parses an ASCII string.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed ASCII string.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static AsciiString parseString(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		return parser.readString();
	}

	/**
	 * Parses an ASCII string if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed ASCII string.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static AsciiString parseStringIf(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseString(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses an ASCII string if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed ASCII string.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static AsciiString parseStringIf(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseString(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses an unsigned bit field.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBits Number of bits to parse.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed unsigned bit field.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UBits parseUBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readBits(numberOfBits);
	}

	/**
	 * Parses an unsigned bit field if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBits Number of bits to parse.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed unsigned bit field.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UBits parseUBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseUBits(parser, numberOfBits, errorCode, fieldName) : null;
	}

	/**
	 * Parses an unsigned bit field if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param numberOfBits Number of bits to parse.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed unsigned bit field.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UBits parseUBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUBits(parser, numberOfBits, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 16 bit unsigned integer.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT16 parseUINT16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT16.BYTE_LENGTH, errorCode, fieldName);
		return parser.readUInt16();
	}

	/**
	 * Parses a 16 bit unsigned integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT16 parseUINT16If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseUINT16(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 16 bit unsigned integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 16 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT16 parseUINT16If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT16(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 32 bit unsigned integer.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 32 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT32 parseUINT32(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT32.BYTE_LENGTH, errorCode, fieldName);
		return parser.readUInt32();
	}

	/**
	 * Parses a 32 bit unsigned integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 32 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT32 parseUINT32If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT32(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 8 bit unsigned integer.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 8 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT8 parseUINT8(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT8.BYTE_LENGTH, errorCode, fieldName);
		return parser.readUInt8();
	}

	/**
	 * Parses a 8 bit unsigned integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 8 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT8 parseUINT8If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseUINT8(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses a 8 bit unsigned integer if a given condition is true.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param errorCode Error code in case parsing fails.
	 * @param condition The condition to be true for the integer to be parsed.
	 * @param fieldName Name of the field to parse.
	 * 
	 * @return The parsed 8 bit unsigned integer.
	 * 
	 * @throws SWFParserException Thrown if parsing failed.
	 */
	public static UINT8 parseUINT8If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT8(parser, errorCode, fieldName) : null;
	}
}