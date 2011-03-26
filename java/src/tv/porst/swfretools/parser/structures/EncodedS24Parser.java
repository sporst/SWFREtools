package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses encoded INT24 fields.
 * 
 * @author sp
 */
public final class EncodedS24Parser {

	/**
	 * Parses an encoded INT24 field from the current position of the input parser stream.
	 * 
	 * @param parser The parser that parses the input stream.
	 * @param fieldName Name of the field in the parent structure.
	 * 
	 * @return The parsed field structure.
	 * 
	 * @throws SWFParserException Thrown if the rectangle could not be parsed.
	 */
	public static EncodedS24 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final int bitPosition = 8 * parser.getBytePosition() + parser.getBitPosition();

		int result = parseUINT8(parser, 0x00006, fieldName).value();

		if ((result & 0x00000080) == 0)
		{
			return new EncodedS24(bitPosition, 8, result);
		}

		result = (result & 0x0000007f) | parseUINT8(parser, 0x00006, fieldName).value() << 7;

		if ((result & 0x00004000) == 0)
		{
			return new EncodedS24(bitPosition, 16, result);
		}

		result = (result & 0x00003fff) | parseUINT8(parser, 0x00006, fieldName).value() << 14;

		if ((result & 0x00200000) == 0)
		{
			return new EncodedS24(bitPosition, 24, result);
		}

		result = (result & 0x001fffff) | parseUINT8(parser, 0x00006, fieldName).value() << 21;

		return new EncodedS24(bitPosition, 32, result);
	}
}