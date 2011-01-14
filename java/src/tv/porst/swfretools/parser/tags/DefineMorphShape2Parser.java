package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphFillStyleArrayParser;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray2Parser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

/**
 * Class for parsing DefineMorphShape2 tags.
 * 
 * @author sp
 */
public final class DefineMorphShape2Parser {

	/**
	 * Parses a DefineMorphShape2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * -
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineMorphShape2Tag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineMorphShape2::CharacterId");
		final Rect startBounds = RectParser.parse(parser, "DefineMorphShape2::StartBounds");
		final Rect endBounds = RectParser.parse(parser, "DefineMorphShape2::EndBounds");
		final Rect startEdgeBounds = RectParser.parse(parser, "DefineMorphShape2::StartEdgeBounds");
		final Rect endEdgeBounds = RectParser.parse(parser, "DefineMorphShape2::EndEdgeBounds");
		final Bits reserved = parseBits(parser, 6, 0x00006, "DefineMorphShape::Reserved");
		final Flag useNonScalingStrokes = parseFlag(parser, 0x00006, "DefineMorphShape2::UseNonScalingStrokes");
		final Flag useScalingStrokes = parseFlag(parser, 0x00006, "DefineMorphShape2::UseScalingStrokes");
		final UINT32 offset = parseUINT32(parser, 0x00006, "DefineMorphShape2::Offset");
		final MorphFillStyleArray morphFillStyles = MorphFillStyleArrayParser.parse(parser, "DefineMorphShape::MorphFillStyleArray");
		final MorphLineStyleArray2 morphLineStyles = MorphLineStyleArray2Parser.parse(parser, "DefineMorphShape::MorphLineSyleArray");
		final Shape startEdges = ShapeParser.parse(parser, "DefineMorphShape2::StartEdges");
		final Shape endEdges = ShapeParser.parse(parser, "DefineMorphShape2::EndEdges");

		return new DefineMorphShape2Tag(header, characterId, startBounds, endBounds, startEdgeBounds, endEdgeBounds, reserved, useNonScalingStrokes, useScalingStrokes, offset, morphFillStyles, morphLineStyles, startEdges, endEdges);
	}
}