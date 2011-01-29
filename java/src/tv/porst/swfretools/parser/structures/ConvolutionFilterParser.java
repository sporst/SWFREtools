package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFloat;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.UINT8;
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
		final Float32[] matrix = new Float32[matrixX.value() * matrixY.value()];

		for (int i=0;i<matrix.length;i++) {
			matrix[i] = parseFloat(parser, 0x00006, String.format(fieldName + "::Matrix[%d]", i));
		}

		final RGBA defaultColor = RGBAParser.parse(parser, fieldName + "::DefaultColor");

		final Bits reserved = parseBits(parser, 6, 0x00006, fieldName + "Reserved");
		final Flag clamp = parseFlag(parser, 0x00006, fieldName + "::Clamp");
		final Flag preserveAlpha = parseFlag(parser, 0x00006, fieldName + "::PreserveAlpha");

		return new ConvolutionFilter(matrixX, matrixY, divisor, bias, matrix, defaultColor, reserved, clamp, preserveAlpha);
	}
}