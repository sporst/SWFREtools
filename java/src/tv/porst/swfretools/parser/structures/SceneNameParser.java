package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;

public class SceneNameParser {

	public static SceneName parse(final BinaryParser parser, final String fieldName) {
		final EncodedU32 offset = EncodedU32Parser.parse(parser, fieldName + "::Offset");
		final PString name = parser.readString();

		return new SceneName(offset, name);
	}

}
