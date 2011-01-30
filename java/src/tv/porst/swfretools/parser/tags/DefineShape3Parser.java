package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3;
import tv.porst.swfretools.parser.structures.ShapeWithStyle3Parser;

/**
 * Class for parsing DefineShape3 tags.
 * 
 * @author sp
 */
public final class DefineShape3Parser {

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
	public static DefineShape3Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 shapeId = parseUINT16(parser, 0x00006, "DefineShape3::ShapeID");
		final Rect shapeBounds = RectParser.parse(parser, "DefineShape3::ShapeBounds");
		final ShapeWithStyle3 shapes = ShapeWithStyle3Parser.parse(parser, "DefineShape3::Shapes");

		return new DefineShape3Tag(header, shapeId, shapeBounds, shapes);
	}
}