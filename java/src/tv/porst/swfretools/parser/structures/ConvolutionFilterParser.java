package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFloat;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ConvolutionFilter structures.
 * 
 * @author sp
 */
public final class ConvolutionFilterParser {

	/**
	 * Parses a ConvolutionFilter structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ConvolutionFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 matrixX = parseUINT8(parser, 0x00006, fieldName + "::MatrixX");
		final UINT8 matrixY = parseUINT8(parser, 0x00006, fieldName + "::MatrixY");
		final Float32 divisor = parseFloat(parser, 0x00006, fieldName + "::Divisor");
		final Float32 bias = parseFloat(parser, 0x00006, fieldName + "::Bias");
		final List<Float32> matrix = new ArrayList<Float32>();

		for (int i=0;i<matrixX.value() * matrixY.value();i++) {
			matrix.add(parseFloat(parser, 0x00006, String.format(fieldName + "::Matrix[%d]", i)));
		}

		final RGBA defaultColor = RGBAParser.parse(parser, fieldName + "::DefaultColor");

		final UBits reserved = parseUBits(parser, 6, 0x00006, fieldName + "Reserved");
		final Flag clamp = parseFlag(parser, 0x00006, fieldName + "::Clamp");
		final Flag preserveAlpha = parseFlag(parser, 0x00006, fieldName + "::PreserveAlpha");

		return new ConvolutionFilter(matrixX, matrixY, divisor, bias, new Float32List(matrix), defaultColor, reserved, clamp, preserveAlpha);
	}
}