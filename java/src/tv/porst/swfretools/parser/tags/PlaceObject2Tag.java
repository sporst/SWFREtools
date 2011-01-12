package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;


public class PlaceObject2Tag extends Tag {

	public PlaceObject2Tag(final RecordHeader header, final Flag placeFlagHasClipActions,
			final Flag placeFlagHasClipDepth, final Flag placeFlagHasName,
			final Flag placeFlagHasRatio, final Flag placeFlagHasColorTransform,
			final Flag placeFlagHasMatrix, final Flag placeFlagHasCharacter,
			final Flag placeFlagHasMove, final UINT16 depth, final UINT16 characterId, final Matrix matrix,
			final CxFormWithAlpha colorTransform, final UINT16 ratio, final PString name,
			final UINT16 clipDepth, final ClipActions clipActions) {

		super(header);
	}

}
