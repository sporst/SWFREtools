package tv.porst.swfretools.parser.tags;

import static tv.porst.splib.io.BinaryParserHelpers.readStringIf;
import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.ClipActionsParser;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.CxFormWithAlphaParser;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.FilterListParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class PlaceObject3Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser, final int version) {

		final boolean placeFlagHasClipActions = parser.readFlag();
		final boolean placeFlagHasClipDepth = parser.readFlag();
		final boolean placeFlagHasName = parser.readFlag();
		final boolean placeFlagHasRatio = parser.readFlag();
		final boolean placeFlagHasColorTransform = parser.readFlag();
		final boolean placeFlagHasMatrix = parser.readFlag();
		final boolean placeFlagHasCharacter = parser.readFlag();
		final boolean placeFlagHasMove = parser.readFlag();
		final int reserved = parser.readBits(3);
		final boolean placeFlagHasImage = parser.readFlag();
		final boolean placeFlagHasClassName = parser.readFlag();
		final boolean placeFlagHasCacheAsBitmap = parser.readFlag();
		final boolean placeFlagHasBlendMode = parser.readFlag();
		final boolean placeFlagHasFilterList = parser.readFlag();

		final UINT16 depth = parser.readUInt16();
		final String className = readStringIf(parser, placeFlagHasClassName || (placeFlagHasImage && placeFlagHasCharacter));

		final UINT16 characterId = placeFlagHasCharacter ? parser.readUInt16() : null;
		final Matrix matrix = placeFlagHasMatrix ? MatrixParser.parse(parser) : null;
		final CxFormWithAlpha colorTransform = placeFlagHasColorTransform ? CxFormWithAlphaParser.parse(parser) : null;
		final UINT16 ratio = placeFlagHasRatio ? parser.readUInt16() : null;
		final String name = readStringIf(parser, placeFlagHasName);
		final UINT16 clipDepth = placeFlagHasClipDepth ? parser.readUInt16() : null;

		final FilterList surfaceFilterList = placeFlagHasFilterList ? FilterListParser.parse(parser) : null;
		final UINT8 blendMode = placeFlagHasBlendMode ? parser.readUInt8() : null;
		final UINT8 bitmapCache = placeFlagHasCacheAsBitmap ? parser.readUInt8() : null;

		final ClipActions clipActions = placeFlagHasClipActions ? ClipActionsParser.parse(parser, version) : null;

		return new PlaceObject3Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, reserved, depth, className, characterId,
				matrix, colorTransform, ratio, name, clipDepth, surfaceFilterList, blendMode, bitmapCache, clipActions);
	}

}
