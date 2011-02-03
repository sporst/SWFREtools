package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseSBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import tv.porst.splib.binaryparser.Bits;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses SWF Rect structures.
 * 
 * @author sp
 */
public final class RectParser {

	/**
	 * Parses a Rect structure from the current position of the input parser stream.
	 * 
	 * @param parser The parser that parses the input stream.
	 * @param fieldName Name of the Rect structure in the parent structure.
	 * 
	 * @return The parsed Rect structure.
	 * 
	 * @throws SWFParserException Thrown if the rectangle could not be parsed.
	 */
	public static Rect parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		if (parser == null) {
			throw new IllegalArgumentException("Parser argument must not be null");
		}

		final UBits nBits = parseUBits(parser, 5, 0x00006, fieldName + "::NBits");

		// It is unclear what happens if nBits is 0. This situation is not specified
		// in the SWF file format reference.

		if (nBits.value() == 0) {
			return new Rect(nBits, null, null, null, null);
		}

		final Bits xMin = parseSBits(parser, nBits.value(), 0x00006, fieldName + "::XMin");
		final Bits xMax = parseSBits(parser, nBits.value(), 0x00006, fieldName + "::XMax");
		final Bits yMin = parseSBits(parser, nBits.value(), 0x00006, fieldName + "::YMin");
		final Bits yMax = parseSBits(parser, nBits.value(), 0x00006, fieldName + "::YMax");

		parser.align();

		return new Rect(nBits, xMin, xMax, yMin, yMax);
	}
}