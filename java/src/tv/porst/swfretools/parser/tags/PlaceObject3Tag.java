package tv.porst.swfretools.parser.tags;

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
			final int reserved, final int depth, final String className, final int characterId,
			final Matrix matrix, final CxFormWithAlpha colorTransform, final int ratio,
			final String name, final int clipDepth, final FilterList surfaceFilterList,
			final int blendMode, final int bitmapCache, final ClipActions clipActions) {

		super(header);
	}
}
