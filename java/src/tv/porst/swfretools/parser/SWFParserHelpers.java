package tv.porst.swfretools.parser;

import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.Float16;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.INT16;
import tv.porst.splib.io.INT32;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.SBits;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.ByteArray;

public class SWFParserHelpers {

	public static void checkNull(final Object object, final String string) {
		if (object == null) {
			throw new IllegalArgumentException(String.format("%s variable must not be null"));
		}

	}

	public static Bits parseBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readBits(numberOfBits);
	}

	public static Bits parseBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		if (condition) {
			return parseBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static Bits parseBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		if (condition.value()) {
			return parseBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static ByteArray parseByteArray(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, numberOfBytes, errorCode, fieldName);

		return null;
	}

	public static ByteArray parseByteArrayIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseByteArray(parser, numberOfBytes, errorCode, fieldName) : null;
	}

	public static ByteArray parseByteArrayIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseByteArray(parser, numberOfBytes, errorCode, fieldName) : null;
	}

	public static Flag parseFlag(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, 1, errorCode, fieldName);

		return parser.readFlag();
	}

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
		return parser.readSInt32();
	}

	public static SBits parseSBits(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final String fieldName) throws SWFParserException {
		throwIfB(parser, numberOfBits, errorCode, fieldName);

		return parser.readSBits(numberOfBits);
	}

	public static SBits parseSBitsIf(final SWFBinaryParser parser, final int numberOfBits, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		if (condition) {
			return parseSBits(parser, numberOfBits, errorCode, fieldName);
		}
		else {
			return null;
		}
	}

	public static PString parseString(final SWFBinaryParser parser, final int length, final int errorCode, final String fieldName) throws SWFParserException {
		return null;
	}

	public static PString parseString(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		return null;
	}

	public static PString parseStringIf(final SWFBinaryParser parser, final int errorCode, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parseString(parser, errorCode, fieldName) : null;
	}

	public static PString parseStringIf(final SWFBinaryParser parser, final int errorCode, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parseString(parser, errorCode, fieldName) : null;
	}

	public static UINT16 parseUINT16(final SWFBinaryParser parser, final int errorCode, final String fieldName) throws SWFParserException {
		throwIf(parser, UINT16.LENGTH, errorCode, fieldName);
		return parser.readUInt16();
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

	private static void throwIf(final SWFBinaryParser parser, final int numberOfBytes, final int errorCode, final String fieldName) throws SWFParserException {
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
