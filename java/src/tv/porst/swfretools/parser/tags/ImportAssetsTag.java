package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.AsciiString;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SymbolList;

/**
 * Represents an ImportAssets tag.
 */
public final class ImportAssetsTag extends Tag {

	/**
	 * URL where the source SWF file can be found.
	 */
	private final AsciiString url;

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
	 * @param count Number of assets to import.
	 * @param symbols List of imported assets.
	 */
	public ImportAssetsTag(final RecordHeader header, final AsciiString url, final UINT16 count, final SymbolList symbols) {
		super(header);

		this.url = url;
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