package tv.porst.swfretools.parser.tags;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.structures.RecordHeader;
import tv.porst.swfretools.parser.structures.ZoneRecord;

/**
 * Represents a DefineFontAlignZones tag.
 * 
 * @author sp
 *
 */
public final class DefineFontAlignZonesTag extends Tag {

	/**
	 * ID of font to use.
	 */
	private final UINT16 fontId;

	/**
	 * Font thickness hint.
	 */
	private final UBits csmTableHint;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Alignment zone information for each glyph.
	 */
	private final List<ZoneRecord> zoneTable;

	/**
	 * Creates a new DefineFontAlignZones tag object.
	 * 
	 * @param header Tag header.
	 * @param fontId ID of font to use.
	 * @param csmTableHint Font thickness hint.
	 * @param reserved Reserved bits.
	 * @param zoneTable Alignment zone information for each glyph.
	 */
	public DefineFontAlignZonesTag(final RecordHeader header, final UINT16 fontId,
			final UBits csmTableHint, final UBits reserved, final List<ZoneRecord> zoneTable) {

		super(header);

		this.fontId = fontId;
		this.csmTableHint = csmTableHint;
		this.reserved = reserved;
		this.zoneTable = new ArrayList<ZoneRecord>(zoneTable);
	}

	/**
	 * Returns the font thickness hint.
	 * 
	 * @return The font thickness hint.
	 */
	public UBits getCsmTableHint() {
		return csmTableHint;
	}

	/**
	 * Returns the ID of font to use.
	 * 
	 * @return The ID of font to use.
	 */
	public UINT16 getFontId() {
		return fontId;
	}

	/**
	 * Returns the reserved bits.
	 * 
	 * @return The reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the alignment zone information for each glyph.
	 * 
	 * @return The alignment zone information for each glyph.
	 */
	public List<ZoneRecord> getZoneTable() {
		return new ArrayList<ZoneRecord>(zoneTable);
	}
}