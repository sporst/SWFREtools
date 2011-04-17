package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle;
import tv.porst.swfretools.parser.structures.ShapeWithStyleParser;

/**
 * Class for parsing DefineShape2 tags.
 */
public final class DefineShape2Parser {

	/**
	 * Parses a DefineShape2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineShape2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 shapeId = parseUINT16(parser, 0x00006, "DefineShape2::ShapeID");
		final Rect shapeBounds = RectParser.parse(parser, "DefineShape2::ShapeBounds");
		final ShapeWithStyle shapes = ShapeWithStyleParser.parse(parser, "DefineShape2::Shapes");

		return new DefineShape2Tag(header, shapeId, shapeBounds, shapes);
	}
}