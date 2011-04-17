package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a Metadata tag.
 */
public final class MetadataTag extends Tag {

	/**
	 * XML metadata
	 */
	private final AsciiString metadata;

	/**
	 * Creates a new Metadata tag object.
	 * 
	 * @param header Tag header.
	 * @param metadata XML metadata.
	 */
	public MetadataTag(final RecordHeader header, final AsciiString metadata) {
		super(header);

		this.metadata = metadata;
	}

	/**
	 * Returns the XML metadata.
	 * 
	 * @return The XML metadata.
	 */
	public AsciiString getMetadata() {
		return metadata;
	}
}