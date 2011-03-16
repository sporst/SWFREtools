package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SymbolList;

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
	private final AsciiString url;

	/**
	 * First reserved byte.
	 */
	private final UINT8 reserved;

	/**
	 * Second reserved byte.
	 */
	private final UINT8 reserved2;

	/**
	 * Number of assets to import.
	 */
	private final UINT16 count;

	/**
	 * List of imported assets.
	 */
	private final SymbolList symbols;

	/**
	 * Creates a new ImportAssets tag object.
	 * 
	 * @param header Tag header.
	 * @param url URL where the source SWF file can be found.
	 * @param reserved First reserved byte.
	 * @param reserved2 Second reserved byte.
	 * @param count Number of assets to import.
	 * @param symbols List of imported assets.
	 */
	public ImportAssets2Tag(final RecordHeader header, final AsciiString url, final UINT8 reserved, final UINT8 reserved2, final UINT16 count, final SymbolList symbols) {

		super(header);

		this.url = url;
		this.reserved = reserved;
		this.reserved2 = reserved2;
		this.count = count;
		this.symbols = symbols;
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
	public SymbolList getSymbols() {
		return symbols;
	}

	/**
	 * Returns the URL where the source SWF file can be found.
	 * 
	 * @return The URL where the source SWF file can be found.
	 */
	public AsciiString getUrl() {
		return url;
	}
}