package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class PlaceObject2Tag extends Tag {

	public PlaceObject2Tag(final RecordHeader header, final int placeFlagHasClipActions,
			final int placeFlagHasClipDepth, final int placeFlagHasName,
			final int placeFlagHasRatio, final int placeFlagHasColorTransform,
			final int placeFlagHasMatrix, final int placeFlagHasCharacter,
			final int placeFlagHasMove, final int depth, final int characterId, final Matrix matrix,
			final CxFormWithAlpha colorTransform, final int ratio, final String name,
			final int clipDepth, final ClipActions clipActions) {

		super(header);
	}

}
