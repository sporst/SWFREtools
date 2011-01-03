package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class SoundInfoParser {

	public static SoundInfo parse(final BinaryParser parser) {
		final int reserved = parser.readBits(2);
		final boolean syncStop = parser.readFlag();
		final boolean syncNoMultiple = parser.readFlag();
		final boolean hasEnvelope = parser.readFlag();
		final boolean hasLoops = parser.readFlag();
		final boolean hasOutPoint = parser.readFlag();
		final boolean hasInPoint = parser.readFlag();

		final long inPoint = hasInPoint ? parser.readUInt32() : 0;
		final long outPoint = hasOutPoint ? parser.readUInt32() : 0;
		final int loopCount = hasLoops ? parser.readUInt16() : 0;
		final int envPoints = hasEnvelope ? parser.readUInt8() : 0;

		final List<SoundEnvelope> envelopeRecords = new ArrayList<SoundEnvelope>();

		if (hasEnvelope) {
			for (int i=0;i<envPoints;i++) {
				envelopeRecords.add(SoundEnvelopeParser.parse(parser));
			}
		}

		return new SoundInfo(reserved, syncStop, syncNoMultiple, hasEnvelope, hasLoops,
				hasOutPoint, hasInPoint, inPoint, outPoint, loopCount, envPoints,
				envelopeRecords);
	}

}
