package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;
import tv.porst.swfretools.parser.structures.SoundInfoParser;

public class StartSound2Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final String soundClassName = parser.readString();
		final SoundInfo soundInfo = SoundInfoParser.parse(parser);

		return new StartSound2Tag(header, soundClassName, soundInfo);
	}

}
