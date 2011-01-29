package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FillStyle3 structures.
 * 
 * @author sp
 */
public final class FillStyle3Parser {

	/**
	 * Returns the gradient of the fill style depending on the fill style type.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fillStyleType The fill style type.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed gradient.
	 * 
	 * @throws SWFParserException Thrown if the gradient could not be parsed.
	 */
	private static IGradient getGradient(final SWFBinaryParser parser, final int fillStyleType, final String fieldName) throws SWFParserException {

		if (fillStyleType == 0x10 || fillStyleType == 0x12) {
			return Gradient3Parser.parse(parser, fieldName);
		}
		else if (fillStyleType == 0x13) {
			return FocalGradientParser.parse(parser, fieldName);
		}
		else {
			return null;
		}
	}

	/**
	 * Parses a FillStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyle3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleType = parseUINT8(parser, 0x00006, fieldName + "::FillStyleType");
		final int fillStyleTypeValue = fillStyleType.value();
		final RGBA color = RGBAParser.parseIf(parser, fillStyleTypeValue == 0x00, fieldName + "::Color");
		final Matrix gradientMatrix = MatrixParser.parseIf(parser, fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12 || fillStyleTypeValue == 0x13, fieldName + "::GradientMatrix");
		final IGradient gradient = getGradient(parser, fillStyleTypeValue, fieldName + "::Gradient");
		final UINT16 bitmapId = parseUINT16If(parser, 0x00006, fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43, fieldName + "::BitmapID");
		final Matrix bitmapMatrix= MatrixParser.parseIf(parser, fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43, fieldName + "::BitmapMatrix");

		return new FillStyle3(fillStyleType, color, gradientMatrix, gradient, bitmapId, bitmapMatrix);

	}

	/**
	 * Parses a FillStyle structure if the passed condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition that must be true for the structure to be parsed.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the structure could not be parsed.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyle3 parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}