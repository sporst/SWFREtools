package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.MorphFillStyleArray;
import tv.porst.swfretools.parser.structures.MorphFillStyleArrayParser;
import tv.porst.swfretools.parser.structures.MorphLineStyleArray;
import tv.porst.swfretools.parser.structures.MorphLineStyleArrayParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Rect;
import tv.porst.swfretools.parser.structures.RectParser;
import tv.porst.swfretools.parser.structures.Shape;
import tv.porst.swfretools.parser.structures.ShapeParser;

/**
 * Class for parsing DefineMorphShape tags.
 * 
 * @author sp
 */
public final class DefineMorphShapeParser {

	/**
	 * Parses a DefineMorphShape tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DefineMorphShapeTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "DefineMorphShape::CharacterId");
		final Rect startBounds = RectParser.parse(parser, "DefineMorphShape::StartBounds");
		final Rect endBounds = RectParser.parse(parser, "DefineMorphShape::EndBounds");
		final UINT32 offset = parseUINT32(parser, 0x00006, "DefineMorphShape::Offset");
		final MorphFillStyleArray morphFillStyles = MorphFillStyleArrayParser.parse(parser, "DefineMorphShape::MorphFillStyles");
		final MorphLineStyleArray morphLineStyles = MorphLineStyleArrayParser.parse(parser, "DefineMorphShape::MorphLineStyles");
		final Shape startEdges = ShapeParser.parse(parser, "DefineMorphShape::StartEdges");
		final Shape endEdges = ShapeParser.parse(parser, "DefineMorphShape::EndEdges");

		return new DefineMorphShapeTag(header, characterId, startBounds, endBounds, offset, morphFillStyles, morphLineStyles, startEdges, endEdges);
	}
}