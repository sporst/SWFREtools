package tv.porst.swfretools.parser;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.BinaryParserHelpers;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float16;
import tv.porst.splib.binaryparser.Float32;
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

		return new ByteArray(parser.getBytePosition() - (int) numberOfBytes, BinaryParserHelpers.readByteArray(parser, (int) numberOfBytes));
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

	public static Float32 parseFloat(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFloat();
	}

	public static Float16 parseFloat16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFloat16();
	}

	public static INT16 parseINT16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT16.LENGTH, errorCode, fieldName);
		return parser.readInt16();
	}

	public static INT16 parseINT16If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseINT16(parser, errorCode, fieldName) : null;
	}

	public static INT16 parseINT16If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseINT16(parser, errorCode, fieldName) : null;
	}

	public static INT32 parseINT32(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, INT32.LENGTH, errorCode, fieldName);
		return parser.readInt32();
	}

	public static Bits parseSBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readSBits(numberOfBits);
	}

	public static Bits parseSBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		if (condition) {
			return parseSBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static AsciiString parseString(final SWFBinaryParser parser, final int length, final int errorCode, final String fieldName) throws SWFParserException {
		return null;
	}

	public static AsciiString parseString(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		return null;
	}

	public static AsciiString parseStringIf(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseString(parser, errorCode, fieldName) : null;
	}

	public static AsciiString parseStringIf(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseString(parser, errorCode, fieldName) : null;
	}

	/**
	 * Parses an unsigned bit field.
	 * 
	 * @param parser
	 * @param numberOfBits
	 * @param errorCode
	 * @param fieldName
	 * @return
	 * @throws SWFParserException
	 */
	public static UBits parseUBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readBits(numberOfBits);
	}

	public static UBits parseUBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		if (condition) {
			return parseUBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static UBits parseUBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		if (condition.value()) {
			return parseUBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static UINT16 parseUINT16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT16.LENGTH, errorCode, fieldName);
		return parser.readUInt16();
	}

	public static UINT16 parseUINT16If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseUINT16(parser, errorCode, fieldName) : null;
	}

	public static UINT16 parseUINT16If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT16(parser, errorCode, fieldName) : null;
	}

	public static UINT32 parseUINT32(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT32.LENGTH, errorCode, fieldName);
		return parser.readUInt32();
	}

	public static UINT32 parseUINT32If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT32(parser, errorCode, fieldName) : null;
	}

	public static UINT8 parseUINT8(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT8.LENGTH, errorCode, fieldName);
		return parser.readUInt8();
	}

	public static UINT8 parseUINT8If(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseUINT8(parser, errorCode, fieldName) : null;
	}

	public static UINT8 parseUINT8If(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseUINT8(parser, errorCode, fieldName) : null;
	}

	private static void throwIf(final SWFBinaryParser parser, final long numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBytesLeft(parser, numberOfBytes)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s (%08X)", fieldName, parser.getBytePosition()));
		}
	}

	private static void throwIfB(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		if (!BinaryParserHelpers.hasBitsLeft(parser, numberOfBytes)) {
			throw new SWFParserException(errorCode, parser.getBytePosition(), String.format("Read beyond file while parsing %s (%08X)", fieldName, parser.getBytePosition()));
		}
	}
}
