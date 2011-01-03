package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.PString;

public class FrameLabelsParser {

	public static FrameLabel parse(final BinaryParser parser) {
		final long offset = EncodedU32Parser.parse(parser);
		final PString name = parser.readString();

		return new FrameLabel(offset, name);
	}

}
