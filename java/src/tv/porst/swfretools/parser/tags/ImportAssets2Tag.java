package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.PString;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Symbol;

/**
 * Represents an ImportAssets2 tag.
 * 
 * @author sp
 *
 */
public final class ImportAssets2Tag extends Tag {

	/**
	 * URL where the source SWF file can be found.
	 */
	private final PString url;

	/**
	 * Number of assets to import.
	 */
	private final UINT16 count;

	/**
	 * List of imported assets.
	 */
	private final List<Symbol> tags;

	/**
	 * First reserved byte.
	 */
	private final UINT8 reserved;

	/**
	 * Second reserved byte.
	 */
	private final UINT8 reserved2;

	/**
	 * Creates a new ImportAssets tag object.
	 * 
	 * @param header Tag header.
	 * @param url URL where the source SWF file can be found.
	 * @param reserved First reserved byte.
	 * @param reserved2 Second reserved byte.
	 * @param count Number of assets to import.
	 * @param tags List of imported assets.
	 */
	public ImportAssets2Tag(final RecordHeader header, final PString url, final UINT8 reserved, final UINT8 reserved2, final UINT16 count, final List<Symbol> tags) {

		super(header);

		this.url = url;
		this.reserved = reserved;
		this.reserved2 = reserved2;
		this.count = count;
		this.tags = new ArrayList<Symbol>(tags);
	}

	/**
	 * Returns the number of assets to import.
	 * 
	 * @return The number of assets to import.
	 */
	public UINT16 getCount() {
		return count;
	}

	/**
	 * Returns the first reserved byte.
	 * 
	 * @return The first reserved byte.
	 */
	public UINT8 getReserved() {
		return reserved;
	}

	/**
	 * Returns the second reserved byte.
	 * 
	 * @return The second reserved byte.
	 */
	public UINT8 getReserved2() {
		return reserved2;
	}

	/**
	 * Returns the list of imported assets.
	 * 
	 * @return The list of imported assets.
	 */
	public List<Symbol> getTags() {
		return tags;
	}

	/**
	 * Returns the URL where the source SWF file can be found.
	 * 
	 * @return The URL where the source SWF file can be found.
	 */
	public PString getUrl() {
		return url;
	}
}