package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseStringIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8If;
import static tv.porst.swfretools.parser.structures.ClipActionsParser.parseIf;
import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.CxFormWithAlphaParser;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.FilterListParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing PlaceObject3 tags.
 * 
 * @author sp
 */
public final class PlaceObject3Parser {

	/**
	 * Parses a PlaceObject3 tag.
	 * 
	 * @param header Previously parsed header of the tag.
	 * @param parser Provides the input data.
	 * @param version Flash version number which was read from the SWF file header.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static PlaceObject3Tag parse(final RecordHeader header, final SWFBinaryParser parser, final int version) throws SWFParserException {

		final Flag placeFlagHasClipActions = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasClipActions");
		final Flag placeFlagHasClipDepth = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasClipDepth");
		final Flag placeFlagHasName = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasName");
		final Flag placeFlagHasRatio = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasRatio");
		final Flag placeFlagHasColorTransform = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasColorTransform");
		final Flag placeFlagHasMatrix = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasMatrix");
		final Flag placeFlagHasCharacter = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasCharacter");
		final Flag placeFlagHasMove = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasMove");
		final UBits reserved = parseUBits(parser, 0x0000006, 3, "PlaceObject3::Reserved");
		final Flag placeFlagHasImage = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasImage");
		final Flag placeFlagHasClassName = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasClassName");
		final Flag placeFlagHasCacheAsBitmap = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasCacheAsBitmap");
		final Flag placeFlagHasBlendMode = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasBlendMode");
		final Flag placeFlagHasFilterList = parseFlag(parser, 0x00006, "PlaceObject3::PlaceFlagHasFilterList");
		final UINT16 depth = parseUINT16(parser, 0x00005, "PlaceObject3::Depth");
		final AsciiString className = parseStringIf(parser, 0x00006, placeFlagHasClassName.value() || (placeFlagHasImage.value() && placeFlagHasCharacter.value()), "PlaceObject3::ClassName");
		final UINT16 characterId = parseUINT16If(parser, 0x00006, placeFlagHasCharacter, "PlaceObject3::CharacterId");
		final Matrix matrix = MatrixParser.parseIf(parser, placeFlagHasMatrix, "PlaceObject3::Matrix");
		final CxFormWithAlpha colorTransform = CxFormWithAlphaParser.parseIf(parser, placeFlagHasColorTransform, "PlaceObject3::CxFormWithAlpha");
		final UINT16 ratio = parseUINT16If(parser, 0x00006, placeFlagHasRatio, "PlaceObject3::Ratio");
		final AsciiString name = parseStringIf(parser, 0x00006, placeFlagHasName, "PlaceObject3::Name");
		final UINT16 clipDepth = parseUINT16If(parser, 0x00006, placeFlagHasClipDepth, "PlaceObject3::ClipDepth");
		final FilterList surfaceFilterList = FilterListParser.parseIf(parser, placeFlagHasFilterList, "PlaceObject3::SurfaceFilterList");
		final UINT8 blendMode = parseUINT8If(parser, 0x00006, placeFlagHasBlendMode, "PlaceObject3::BlendMode");
		final UINT8 bitmapCache = parseUINT8If(parser, 0x00006, placeFlagHasCacheAsBitmap, "PlaceObject3::BitmapCache");
		final ClipActions clipActions = parseIf(parser, version, placeFlagHasClipActions, "PlaceObject3::ClipActions");

		return new PlaceObject3Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, reserved, placeFlagHasImage, placeFlagHasClassName,
				placeFlagHasCacheAsBitmap, placeFlagHasBlendMode, placeFlagHasFilterList, depth, className, characterId,
				matrix, colorTransform, ratio, name, clipDepth, surfaceFilterList, blendMode, bitmapCache, clipActions);
	}

}
