package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

public class FileAttributesTag extends Tag {

	public FileAttributesTag(final RecordHeader header, final int reserved,
			final boolean useDirectBit, final boolean useGPU, final boolean hasMetadata,
			final boolean actionScript3, final int reserved2, final boolean useNetwork,
			final int reserved3) {
		super(header);
	}

}
