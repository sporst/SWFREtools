package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses LineStyle4Array structures.
 * 
 * @author sp
 */
public final class LineStyle4ArrayParser {

	/**
	 * Parses a LineStyle4Array structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle4Array parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 lineStyleCount = parseUINT8(parser, 0x00006, fieldName + "::LineStyleCount");
		final UINT16 lineStyleCountExtended = parseUINT16If(parser, 0x00006, lineStyleCount.value() == 0xFF, fieldName + "::LineStyleCountExtended");

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<LineStyle4> lineStyles = new ArrayList<LineStyle4>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(LineStyle4Parser.parse(parser, String.format(fieldName + "::LineStyles[%d]", lineStyles.size())));
		}

		return new LineStyle4Array(lineStyleCount, lineStyleCountExtended, lineStyles);
	}
}