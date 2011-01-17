package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.PString;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a Metadata tag.
 * 
 * @author sp
 *
 */
public final class MetadataTag extends Tag {

	/**
	 * XML metadata
	 */
	private final PString metadata;

	/**
	 * Creates a new Metadata tag object.
	 * 
	 * @param header Tag header.
	 * @param metadata XML metadata.
	 */
	public MetadataTag(final RecordHeader header, final PString metadata) {
		super(header);

		this.metadata = metadata;
	}

	/**
	 * Returns the XML metadata.
	 * 
	 * @return The XML metadata.
	 */
	public PString getMetadata() {
		return metadata;
	}
}