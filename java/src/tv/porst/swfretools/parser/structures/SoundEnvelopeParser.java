package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class SoundEnvelopeParser {

	public static SoundEnvelope parse(final BinaryParser parser) {
		final long pos44 = parser.readUInt32();
		final int leftLevel = parser.readUInt16();
		final int rightLevel = parser.readUInt16();

		return new SoundEnvelope(pos44, leftLevel, rightLevel);
	}

}
