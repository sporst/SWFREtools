package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;

public class SceneNameParser {

	public static SceneName parse(final BinaryParser parser) {
		final long offset = EncodedU32Parser.parse(parser);
		final PString name = parser.readString();

		return new SceneName(offset, name);
	}

}
