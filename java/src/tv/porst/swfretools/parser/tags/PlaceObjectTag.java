package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class PlaceObjectTag extends Tag {

	private final UINT16 characterId;
	private final UINT16 depth;
	private final Matrix matrix;
	private final CxForm colorTransform;

	public PlaceObjectTag(final RecordHeader header, final UINT16 characterId2, final UINT16 depth2,
			final Matrix matrix, final CxForm colorTransform) {
		super(header);

		this.characterId = characterId2;
		this.depth = depth2;
		this.matrix = matrix;
		this.colorTransform = colorTransform;
	}

}
