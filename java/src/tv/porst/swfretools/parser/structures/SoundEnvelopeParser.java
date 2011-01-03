package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;

public class SoundEnvelopeParser {

	public static SoundEnvelope parse(final BinaryParser parser) {
		final UINT32 pos44 = parser.readUInt32();
		final UINT16 leftLevel = parser.readUInt16();
		final UINT16 rightLevel = parser.readUInt16();

		return new SoundEnvelope(pos44, leftLevel, rightLevel);
	}

}
