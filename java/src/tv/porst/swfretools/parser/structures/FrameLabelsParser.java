package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class FrameLabelsParser {

	public static FrameLabel parse(final BinaryParser parser) {
		final long offset = EncodedU32Parser.parse(parser);
		final String name = parser.readString();

		return new FrameLabel(offset, name);
	}

}
