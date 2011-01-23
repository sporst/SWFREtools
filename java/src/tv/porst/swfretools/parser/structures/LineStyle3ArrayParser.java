package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses LineStyle3ArrayStyle structures.
 * 
 * @author sp
 */
public final class LineStyle3ArrayParser {

	/**
	 * Parses a LineStyle3Array structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle3Array parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 lineStyleCount = parseUINT8(parser, 0x00006, fieldName + "::LineStyleCount");
		final UINT16 lineStyleCountExtended = parseUINT16If(parser, 0x00006, lineStyleCount.value() == 0xFF, fieldName + "::LineStyleCountExtended");

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<LineStyle3> lineStyles = new ArrayList<LineStyle3>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyle3Parser.parse(parser, String.format(fieldName + "::LineStyles[%d]", i)));
		}

		return new LineStyle3Array(lineStyleCount, lineStyleCountExtended, lineStyles);
	}

	/**
	 * Parses a LineStyle3Array structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true for this structure to be parsed.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle3Array parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}