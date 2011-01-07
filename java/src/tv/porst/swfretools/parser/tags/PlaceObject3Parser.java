package tv.porst.swfretools.parser.tags;

import static tv.porst.splib.io.BinaryParserHelpers.readStringIf;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
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

	public static Tag parse(final RecordHeader header, final SWFBinaryParser parser, final int version) throws SWFParserException {

		final Flag placeFlagHasClipActions = parser.readFlag();
		final Flag placeFlagHasClipDepth = parser.readFlag();
		final Flag placeFlagHasName = parser.readFlag();
		final Flag placeFlagHasRatio = parser.readFlag();
		final Flag placeFlagHasColorTransform = parser.readFlag();
		final Flag placeFlagHasMatrix = parser.readFlag();
		final Flag placeFlagHasCharacter = parser.readFlag();
		final Flag placeFlagHasMove = parser.readFlag();
		final int reserved = parser.readBits(3);
		final Flag placeFlagHasImage = parser.readFlag();
		final Flag placeFlagHasClassName = parser.readFlag();
		final Flag placeFlagHasCacheAsBitmap = parser.readFlag();
		final Flag placeFlagHasBlendMode = parser.readFlag();
		final Flag placeFlagHasFilterList = parser.readFlag();

		final UINT16 depth = parser.readUInt16();
		final PString className = readStringIf(parser, placeFlagHasClassName.value() || (placeFlagHasImage.value() && placeFlagHasCharacter.value()));

		final UINT16 characterId = placeFlagHasCharacter.value() ? parser.readUInt16() : null;
		final Matrix matrix = placeFlagHasMatrix.value() ? MatrixParser.parse(parser, "Matrix") : null;
		final CxFormWithAlpha colorTransform = placeFlagHasColorTransform.value() ? CxFormWithAlphaParser.parse(parser) : null;
		final UINT16 ratio = placeFlagHasRatio.value() ? parser.readUInt16() : null;
		final PString name = readStringIf(parser, placeFlagHasName.value());
		final UINT16 clipDepth = placeFlagHasClipDepth.value() ? parser.readUInt16() : null;

		final FilterList surfaceFilterList = placeFlagHasFilterList.value() ? FilterListParser.parse(parser) : null;
		final UINT8 blendMode = placeFlagHasBlendMode.value() ? parser.readUInt8() : null;
		final UINT8 bitmapCache = placeFlagHasCacheAsBitmap.value() ? parser.readUInt8() : null;

		final ClipActions clipActions = placeFlagHasClipActions.value() ? ClipActionsParser.parse(parser, version) : null;

		return new PlaceObject3Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, reserved, depth, className, characterId,
				matrix, colorTransform, ratio, name, clipDepth, surfaceFilterList, blendMode, bitmapCache, clipActions);
	}

}
