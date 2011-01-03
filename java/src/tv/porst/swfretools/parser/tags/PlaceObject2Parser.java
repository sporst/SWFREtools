package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.ClipActions;
import tv.porst.swfretools.parser.structures.ClipActionsParser;
import tv.porst.swfretools.parser.structures.CxFormWithAlpha;
import tv.porst.swfretools.parser.structures.CxFormWithAlphaParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class PlaceObject2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser, final int version) {

		final int placeFlagHasClipActions = parser.readBits(1);
		final int placeFlagHasClipDepth = parser.readBits(1);
		final int placeFlagHasName = parser.readBits(1);
		final int placeFlagHasRatio = parser.readBits(1);
		final int placeFlagHasColorTransform = parser.readBits(1);
		final int placeFlagHasMatrix = parser.readBits(1);
		final int placeFlagHasCharacter = parser.readBits(1);
		final int placeFlagHasMove = parser.readBits(1);

		final UINT16 depth = parser.readUInt16();

		final UINT16 characterId = placeFlagHasCharacter == 1 ? parser.readUInt16() : null;
		final Matrix matrix = placeFlagHasMatrix == 1 ? MatrixParser.parse(parser) : null;
		final CxFormWithAlpha colorTransform = placeFlagHasColorTransform == 1 ? CxFormWithAlphaParser.parse(parser) : null;
		final UINT16 ratio = placeFlagHasRatio == 1 ? parser.readUInt16() : null;
		final PString name = placeFlagHasName == 1 ? parser.readString() : null;
		final UINT16 clipDepth = placeFlagHasClipDepth == 1 ? parser.readUInt16() : null;
		final ClipActions clipActions = placeFlagHasClipActions == 1 ? ClipActionsParser.parse(parser, version) : null;

		return new PlaceObject2Tag(header, placeFlagHasClipActions, placeFlagHasClipDepth, placeFlagHasName,
				placeFlagHasRatio, placeFlagHasColorTransform, placeFlagHasMatrix,
				placeFlagHasCharacter, placeFlagHasMove, depth, characterId,
				matrix, colorTransform, ratio, name, clipDepth, clipActions);
	}

}
