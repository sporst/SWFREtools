package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.Symbol;

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
	private final List<Symbol> assets;

	/**
	 * Creates a new ExportAssets tag object.
	 * 
	 * @param header Tag header.
	 * @param count Number of assets to export.
	 * @param assets List of assets to export.
	 */
	public ExportAssetsTag(final RecordHeader header, final UINT16 count, final List<Symbol> assets) {
		super(header);

		this.count = count;
		this.assets = new ArrayList<Symbol>(assets);
	}

	/**
	 * Returns the list of assets to export.
	 * 
	 * @return The list of assets to export.
	 */
	public List<Symbol> getAssets() {
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