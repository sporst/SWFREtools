package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses MorphLineStyleArray2 structures.
 * 
 * @author sp
 */
public final class MorphLineStyleArray2Parser {

	/**
	 * Parses a MorphLineStyleArray2 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphLineStyleArray2 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 lineStyleCount = parseUINT8(parser, 0x00006, fieldName + "::LineStyleCount");
		final UINT16 lineStyleCountExtended = parseUINT16If(parser, 0x00006, lineStyleCount.value() == 0xFF, fieldName + "::LineStyleCountExtended");

		final int normalizedCount = lineStyleCount.value() == 0xFF ? lineStyleCountExtended.value() : lineStyleCount.value();

		final List<MorphLineStyle2> lineStyles = new ArrayList<MorphLineStyle2>();

		for (int i=0;i<normalizedCount;i++) {
			lineStyles.add(MorphLineStyle2Parser.parse(parser, String.format(fieldName + "::LineStyles[%d]", lineStyles.size())));
		}

		return new MorphLineStyleArray2(lineStyleCount, lineStyleCountExtended, lineStyles);
	}
}