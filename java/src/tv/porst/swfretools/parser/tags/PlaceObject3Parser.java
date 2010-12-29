package tv.porst.swfretools.parser.tags;

import static tv.porst.splib.io.BinaryParserHelpers.readStringIf;
import tv.porst.splib.io.BinaryParser;
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

		final int depth = parser.readUInt16();
		final String className = readStringIf(parser, placeFlagHasClassName || (placeFlagHasImage && placeFlagHasCharacter));

		final int characterId = placeFlagHasCharacter ? parser.readUInt16() : 0;
		final Matrix matrix = placeFlagHasMatrix ? MatrixParser.parse(parser) : null;
		final CxFormWithAlpha colorTransform = placeFlagHasColorTransform ? CxFormWithAlphaParser.parse(parser) : null;
		final int ratio = placeFlagHasRatio ? parser.readUInt16() : 0;
		final String name = readStringIf(parser, placeFlagHasName);
		final int clipDepth = placeFlagHasClipDepth ? parser.readUInt16() : 0;

		final FilterList surfaceFilterList = placeFlagHasFilterList ? FilterListParser.parse(parser) : null;
		final int blendMode = placeFlagHasBlendMode ? parser.readUInt8() : 0;
		final int bitmapCache = placeFlagHasCacheAsBitmap ? parser.readUInt8() : 0;

		final ClipActions clipActions = placeFlagHasClipActions ? ClipActionsParser.parse(parser, version) : null;

		return new PlaceObject3Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, reserved, depth, className, characterId,
				matrix, colorTransform, ratio, name, clipDepth, surfaceFilterList, blendMode, bitmapCache, clipActions);
	}

}
