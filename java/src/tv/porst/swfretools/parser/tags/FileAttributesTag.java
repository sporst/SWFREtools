package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class FileAttributesTag extends Tag {

	public FileAttributesTag(final RecordHeader header, final int reserved,
			final Flag useDirectBit, final Flag useGPU, final Flag hasMetadata,
			final Flag actionScript3, final int reserved2, final Flag useNetwork,
			final int reserved3) {
		super(header);
	}

}
