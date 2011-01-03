package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.FilterList;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class PlaceObject3Tag extends Tag {

	public PlaceObject3Tag(final RecordHeader header,
			final boolean placeFlagHasClipActions, final boolean placeFlagHasClipDepth,
			final boolean placeFlagHasName, final boolean placeFlagHasRatio,
			final boolean placeFlagHasColorTransform, final boolean placeFlagHasMatrix,
			final boolean placeFlagHasCharacter, final boolean placeFlagHasMove,
			final int reserved, final UINT16 depth, final String className, final UINT16 characterId,
			final Matrix matrix, final CxFormWithAlpha colorTransform, final UINT16 ratio,
			final String name, final UINT16 clipDepth, final FilterList surfaceFilterList,
			final UINT8 blendMode, final UINT8 bitmapCache, final ClipActions clipActions) {

		super(header);
	}
}
