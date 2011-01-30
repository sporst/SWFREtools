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
 * Parses FillStyle3Array structures.
 * 
 * @author sp
 */
public final class FillStyle3ArrayParser {

	/**
	 * Parses a FillStyle3Array structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyle3Array parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleCount = parseUINT8(parser, 0x00006, fieldName + "::FillStyleCount");
		final UINT16 fillStyleCountExtended = fillStyleCount.value() == 0xFF ? parseUINT16(parser, 0x00006, fieldName + "::FillStyleCountExtended") : null;

		final int normalizedCount = fillStyleCount.value() == 0xFF ? fillStyleCountExtended.value() : fillStyleCount.value();

		final List<FillStyle3> fillStyles = new ArrayList<FillStyle3>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(FillStyle3Parser.parse(parser, String.format(fieldName + "::FillStyles[%d]", fillStyles.size())));
		}

		return new FillStyle3Array(fillStyleCount, fillStyleCountExtended, fillStyles);
	}

	/**
	 * Parses a FillStyleArray structure if a passed condition is true.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition The condition to be true for the structure to be parsed.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the condition is false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FillStyle3Array parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}