package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFloat;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Float32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses ColorMatrixFilter structures.
 * 
 * @author sp
 */
public final class ColorMatrixFilterParser {

	/**
	 * Parses a ColorMatrixFilter structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static ColorMatrixFilter parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final List<Float32> matrix = new ArrayList<Float32>();

		for (int i=0;i<20;i++) {
			matrix.add(parseFloat(parser, 0x00006, String.format(fieldName + "::Matrix[%d]", i)));
		}

		return new ColorMatrixFilter(new Float32List(matrix));
	}
}