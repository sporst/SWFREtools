package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class PlaceObjectTag extends Tag {

	private final int characterId;
	private final int depth;
	private final Matrix matrix;
	private final CxForm colorTransform;

	public PlaceObjectTag(final RecordHeader header, final int characterId, final int depth,
			final Matrix matrix, final CxForm colorTransform) {
		super(header);

		this.characterId = characterId;
		this.depth = depth;
		this.matrix = matrix;
		this.colorTransform = colorTransform;
	}

}
