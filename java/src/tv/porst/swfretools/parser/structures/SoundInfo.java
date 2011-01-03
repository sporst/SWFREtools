package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.Flag;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;

public class SoundInfo {

	public SoundInfo(final int reserved, final Flag syncStop, final Flag syncNoMultiple,
			final Flag hasEnvelope, final Flag hasLoops, final Flag hasOutPoint,
			final Flag hasInPoint, final UINT32 inPoint, final UINT32 outPoint, final UINT16 loopCount,
			final UINT8 envPoints, final List<SoundEnvelope> envelopeRecords) {
		// TODO Auto-generated constructor stub
	}

}
