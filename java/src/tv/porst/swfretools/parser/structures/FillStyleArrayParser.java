package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FillStyleArray structures.
 * 
 * @author sp
 */
public final class FillStyleArrayParser {

	/**
	 * Parses a FillStyleArray structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyleArray parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleCount = parseUINT8(parser, 0x00006, fieldName + "::FillStyleCount");
		final UINT16 fillStyleCountExtended = fillStyleCount.value() == 0xFF ? parseUINT16(parser, 0x00006, fieldName + "::FillStyleCountExtended") : null;

		final int normalizedCount = fillStyleCount.value() == 0xFF ? fillStyleCountExtended.value() : fillStyleCount.value();

		final List<FillStyle> fillStyles = new ArrayList<FillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(FillStyleParser.parse(parser, String.format(fieldName + "::FillStyles[%d]", fillStyles.size())));
		}

		return new FillStyleArray(fillStyleCount, fillStyleCountExtended, new FillStyleList(fillStyles));
	}

	/**
	 * Parses a FillStyle structure if a condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true to parse the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition was not true.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyleArray parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}