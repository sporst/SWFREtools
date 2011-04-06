package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4;
import tv.porst.swfretools.parser.structures.ShapeWithStyle4Parser;

/**
 * Class for parsing DefineShape4 tags.
 * 
 * @author sp
 */
public final class DefineShape4Parser {

	/**
	 * Parses a DefineShape4 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineShape4Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 shapeId = parseUINT16(parser, 0x00006, "DefineShape4::ShapeID");

		final Rect shapeBounds = RectParser.parse(parser, "DefineShape4::ShapeBounds");
		final Rect edgeBounds = RectParser.parse(parser, "DefineShape4::EdgeBounds");
		final UBits reserved = parseUBits(parser, 5, 0x00006, "DefineShape4::Reserved");
		final Flag usesFillWindingRule = parseFlag(parser, 0x00006, "DefineShape4::UsesFillWindingRule");
		final Flag usesNonScalingStrokes = parseFlag(parser, 0x00006, "DefineShape4::UsesNonScalingStrokes");
		final Flag usesScalingStrokes = parseFlag(parser, 0x00006, "DefineShape4::UsesScalingStrokes");
		final ShapeWithStyle4 shapes = ShapeWithStyle4Parser.parse(parser, "DefineShape4::Shapes");

		return new DefineShape4Tag(header, shapeId, shapeBounds, edgeBounds, reserved, usesFillWindingRule, usesNonScalingStrokes, usesScalingStrokes, shapes);
	}
}