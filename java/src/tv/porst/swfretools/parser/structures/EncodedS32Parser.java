package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses encoded INT32 fields.
 * 
 * @author sp
 */
public final class EncodedS32Parser {

	/**
	 * Parses an encoded INT32 field from the current position of the input parser stream.
	 * 
	 * @param parser The parser that parses the input stream.
	 * @param fieldName Name of the field in the parent structure.
	 * 
	 * @return The parsed field structure.
	 * 
	 * @throws SWFParserException Thrown if the rectangle could not be parsed.
	 */
	public static EncodedS32 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final int bitPosition = 8 * parser.getBytePosition() + parser.getBitPosition();

		int result = parseUINT8(parser, 0x00006, fieldName).value();

		if ((result & 0x00000080) == 0)
		{
			return new EncodedS32(bitPosition, 8, result);
		}

		result = (result & 0x0000007f) | parseUINT8(parser, 0x00006, fieldName).value() << 7;

		if ((result & 0x00004000) == 0)
		{
			return new EncodedS32(bitPosition, 16, result);
		}

		result = (result & 0x00003fff) | parseUINT8(parser, 0x00006, fieldName).value() << 14;

		if ((result & 0x00200000) == 0)
		{
			return new EncodedS32(bitPosition, 24, result);
		}

		result = (result & 0x001fffff) | parseUINT8(parser, 0x00006, fieldName).value() << 21;

		if ((result & 0x10000000) == 0)
		{
			return new EncodedS32(bitPosition, 32, result);
		}

		result = (result & 0x0fffffff) | parseUINT8(parser, 0x00006, fieldName).value() << 28;

		return new EncodedS32(bitPosition, 40, result);
	}
}