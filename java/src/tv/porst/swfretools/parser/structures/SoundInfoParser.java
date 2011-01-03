package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;

public class SoundInfoParser {

	public static SoundInfo parse(final BinaryParser parser) {
		final int reserved = parser.readBits(2);
		final boolean syncStop = parser.readFlag();
		final boolean syncNoMultiple = parser.readFlag();
		final boolean hasEnvelope = parser.readFlag();
		final boolean hasLoops = parser.readFlag();
		final boolean hasOutPoint = parser.readFlag();
		final boolean hasInPoint = parser.readFlag();

		final UINT32 inPoint = hasInPoint ? parser.readUInt32() : null;
		final UINT32 outPoint = hasOutPoint ? parser.readUInt32() : null;
		final UINT16 loopCount = hasLoops ? parser.readUInt16() : null;
		final UINT8 envPoints = hasEnvelope ? parser.readUInt8() : null;

		final List<SoundEnvelope> envelopeRecords = new ArrayList<SoundEnvelope>();

		if (hasEnvelope) {
			for (int i=0;i<envPoints.value();i++) {
				envelopeRecords.add(SoundEnvelopeParser.parse(parser));
			}
		}

		return new SoundInfo(reserved, syncStop, syncNoMultiple, hasEnvelope, hasLoops,
				hasOutPoint, hasInPoint, inPoint, outPoint, loopCount, envPoints,
				envelopeRecords);
	}

}
