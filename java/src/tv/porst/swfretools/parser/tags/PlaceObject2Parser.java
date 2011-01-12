package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseStringIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.structures.ClipActionsParser.parseIf;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.CxFormWithAlphaParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing PlaceObject2 tags.
 * 
 * @author sp
 */
public final class PlaceObject2Parser {

	/**
	 * Parses a PlaceObject2 tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static PlaceObject2Tag parse(final RecordHeader header, final SWFBinaryParser parser, final int version) throws SWFParserException {

		final Flag placeFlagHasClipActions = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasClipActions");
		final Flag placeFlagHasClipDepth = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasClipDepth");
		final Flag placeFlagHasName = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasName");
		final Flag placeFlagHasRatio = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasRatio");
		final Flag placeFlagHasColorTransform = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasColorTransform");
		final Flag placeFlagHasMatrix = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasMatrix");
		final Flag placeFlagHasCharacter = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasCharacter");
		final Flag placeFlagHasMove = parseFlag(parser, 0x00006, "PlaceObject2::PlaceFlagHasMove");
		final UINT16 depth = parseUINT16(parser, 0x00005, "PlaceObject2::Depth");
		final UINT16 characterId = parseUINT16If(parser, 0x00006, placeFlagHasCharacter, "PlaceObject2::CharacterId");
		final Matrix matrix = MatrixParser.parseIf(parser, placeFlagHasMatrix, "PlaceObject2::Matrix");
		final CxFormWithAlpha colorTransform = CxFormWithAlphaParser.parseIf(parser, placeFlagHasColorTransform, "PlaceObject2::CxFormWithAlpha");
		final UINT16 ratio = parseUINT16If(parser, 0x00006, placeFlagHasRatio, "PlaceObject2::Ratio");
		final PString name = parseStringIf(parser, 0x00006, placeFlagHasName, "PlaceObject2::Name");
		final UINT16 clipDepth = parseUINT16If(parser, 0x00006, placeFlagHasClipDepth, "PlaceObject2::ClipDepth");
		final ClipActions clipActions = parseIf(parser, version, placeFlagHasClipActions, "PlaceObject2::ClipActions");

		return new PlaceObject2Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, depth, characterId,
				matrix, colorTransform, ratio, name, clipDepth, clipActions);
	}

}
