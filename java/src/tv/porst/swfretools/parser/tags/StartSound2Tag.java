package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SoundInfo;

public class StartSound2Tag extends Tag {

	public StartSound2Tag(final RecordHeader header, final PString soundClassName,
			final SoundInfo soundInfo) {
		super(header);
	}

}
