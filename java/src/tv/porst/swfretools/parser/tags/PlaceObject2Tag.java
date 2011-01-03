package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class PlaceObject2Tag extends Tag {

	public PlaceObject2Tag(final RecordHeader header, final int placeFlagHasClipActions,
			final int placeFlagHasClipDepth, final int placeFlagHasName,
			final int placeFlagHasRatio, final int placeFlagHasColorTransform,
			final int placeFlagHasMatrix, final int placeFlagHasCharacter,
			final int placeFlagHasMove, final UINT16 depth, final UINT16 characterId, final Matrix matrix,
			final CxFormWithAlpha colorTransform, final UINT16 ratio, final String name,
			final UINT16 clipDepth, final ClipActions clipActions) {

		super(header);
	}

}
