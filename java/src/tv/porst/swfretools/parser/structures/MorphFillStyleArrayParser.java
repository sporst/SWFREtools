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
 * Parses MorphFillStyleArray structures.
 * 
 * @author sp
 */
public final class MorphFillStyleArrayParser {

	/**
	 * Parses a MorphFillStyleArray structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphFillStyleArray parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 fillStyleCount = parseUINT8(parser, 0x00006, fieldName + "::FillStyleCount");
		final UINT16 fillStyleCountExtended = parseUINT16If(parser, 0x00006, fillStyleCount.value() == 0xFF, fieldName + "::FillStyleCountExtended");

		final int normalizedCount = fillStyleCount.value() == 0xFF ? fillStyleCountExtended.value() : fillStyleCount.value();

		final List<MorphFillStyle> fillStyles = new ArrayList<MorphFillStyle>();

		for (int i=0;i<normalizedCount;i++) {
			fillStyles.add(MorphFillStyleParser.parse(parser, String.format(fieldName + "::FillStyles[%d]", i)));
		}

		return new MorphFillStyleArray(fillStyleCount, fillStyleCountExtended, new MorphFillStyleList(fillStyles));
	}
}