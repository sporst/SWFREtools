package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.SymbolList;

/**
 * Represents an ExportAssets tag.
 * 
 * @author sp
 *
 */
public final class ExportAssetsTag extends Tag {

	/**
	 * Number of assets to export.
	 */
	private final UINT16 count;

	/**
	 * List of assets to export.
	 */
	private final SymbolList assets;

	/**
	 * Creates a new ExportAssets tag object.
	 * 
	 * @param header Tag header.
	 * @param count Number of assets to export.
	 * @param assets List of assets to export.
	 */
	public ExportAssetsTag(final RecordHeader header, final UINT16 count, final SymbolList assets) {
		super(header);

		this.count = count;
		this.assets = assets;
	}

	/**
	 * Returns the list of assets to export.
	 * 
	 * @return The list of assets to export.
	 */
	public SymbolList getAssets() {
		return assets;
	}

	/**
	 * Returns the number of assets to export.
	 * 
	 * @return The number of assets to export.
	 */
	public UINT16 getCount() {
		return count;
	}
}