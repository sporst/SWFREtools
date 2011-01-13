package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;

public class SoundInfoParser {

	public static SoundInfo parse(final BinaryParser parser) {
		final int reserved = parser.readBits(2);
		final Flag syncStop = parser.readFlag();
		final Flag syncNoMultiple = parser.readFlag();
		final Flag hasEnvelope = parser.readFlag();
		final Flag hasLoops = parser.readFlag();
		final Flag hasOutPoint = parser.readFlag();
		final Flag hasInPoint = parser.readFlag();

		final UINT32 inPoint = hasInPoint.value() ? parser.readUInt32() : null;
		final UINT32 outPoint = hasOutPoint.value() ? parser.readUInt32() : null;
		final UINT16 loopCount = hasLoops.value() ? parser.readUInt16() : null;
		final UINT8 envPoints = hasEnvelope.value() ? parser.readUInt8() : null;

		final List<SoundEnvelope> envelopeRecords = new ArrayList<SoundEnvelope>();

		if (hasEnvelope.value()) {
			for (int i=0;i<envPoints.value();i++) {
				envelopeRecords.add(SoundEnvelopeParser.parse(parser));
			}
		}

		return new SoundInfo(reserved, syncStop, syncNoMultiple, hasEnvelope, hasLoops,
				hasOutPoint, hasInPoint, inPoint, outPoint, loopCount, envPoints,
				envelopeRecords);
	}

	public static SoundInfo parseIf(final SWFBinaryParser parser, final boolean condition, final String fieldName) {
		return condition ? parse(parser) : null;
	}

}
