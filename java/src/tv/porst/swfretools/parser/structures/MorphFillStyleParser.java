package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses MorphFillStyle structures.
 * 
 * @author sp
 */
public final class MorphFillStyleParser {

	/**
	 * Parses a MorphFillStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphFillStyle parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleType = parseUINT8(parser, 0x00006, fieldName + "::FillStyleType");
		final int fillStyleTypeValue = fillStyleType.value();
		final RGBA startColor = RGBAParser.parseIf(parser, fillStyleTypeValue == 0x00, fieldName + "::StartColor");
		final RGBA endColor = RGBAParser.parseIf(parser, fillStyleTypeValue == 0x00, fieldName + "::EndColor");
		final Matrix startGradientMatrix = MatrixParser.parseIf(parser, fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12, fieldName + "::StartGradientMatrix");
		final Matrix endGradientMatrix = MatrixParser.parseIf(parser, fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12, fieldName + "::EndGradientMatrix");
		final MorphGradient gradient = MorphGradientParser.parseIf(parser, fillStyleTypeValue == 0x10 || fillStyleTypeValue == 0x12, fieldName + "::Gradient");
		final UINT16 bitmapId = parseUINT16If(parser, 0x00006, fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43, fieldName + "::BitmapId");
		final Matrix startBitmapMatrix = MatrixParser.parseIf(parser, fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43, fieldName + "::StartBitmapMatrix");
		final Matrix endBitmapMatrix = MatrixParser.parseIf(parser, fillStyleTypeValue >= 0x40 && fillStyleTypeValue <= 0x43, fieldName + "::EndBitmapMatrix");

		return new MorphFillStyle(fillStyleType, startColor, endColor, startGradientMatrix, endGradientMatrix, gradient, bitmapId, startBitmapMatrix, endBitmapMatrix);
	}

	/**
	 * Parses a MorphFillStyle structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition that must be true for the structure to be parsed.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphFillStyle parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}