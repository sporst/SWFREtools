package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a CSMTextSettings tag.
 * 
 * @author sp
 *
 */
public final class CSMTextSettingsTag extends Tag {

	/**
	 * ID for the text to which this tag applies.
	 */
	private final UINT16 textId;

	/**
	 * Rendering engine flag.
	 */
	private final Bits useFlashType;

	/**
	 * Grid fitting flag.
	 */
	private final Bits gridFit;

	/**
	 * First reserved bit field.
	 */
	private final Bits reserved;

	/**
	 * Thickness attribute of the associated text field.
	 */
	private final Float32 thickness;

	/**
	 * Sharpness attribute of the associated text field.
	 */
	private final Float32 sharpness;

	/**
	 * Second reserved bit field.
	 */
	private final UINT8 reserved2;

	/**
	 * Creates a new CSMTextSettings tag object.
	 * 
	 * @param header Tag header.
	 * @param textId ID for the text to which this tag applies.
	 * @param useFlashType Rendering engine flag.
	 * @param gridFit Grid fitting flag.
	 * @param reserved First reserved bit field.
	 * @param thickness Thickness attribute of the associated text field.
	 * @param sharpness Sharpness attribute of the associated text field.
	 * @param reserved2 Second reserved bit field.
	 */
	public CSMTextSettingsTag(final RecordHeader header, final UINT16 textId,
			final Bits useFlashType, final Bits gridFit, final Bits reserved, final Float32 thickness,
			final Float32 sharpness, final UINT8 reserved2) {

		super(header);

		this.textId = textId;
		this.useFlashType = useFlashType;
		this.gridFit = gridFit;
		this.reserved = reserved;
		this.thickness = thickness;
		this.sharpness = sharpness;
		this.reserved2 = reserved2;
	}

	/**
	 * Returns the grid fitting flag.
	 * 
	 * @return The grid fitting flag.
	 */
	public Bits getGridFit() {
		return gridFit;
	}

	/**
	 * Returns the first reserved bit field.
	 * 
	 * @return The first reserved bit field.
	 */
	public Bits getReserved() {
		return reserved;
	}

	/**
	 * Returns the second reserved bit field.
	 * 
	 * @return The second reserved bit field.
	 */
	public UINT8 getReserved2() {
		return reserved2;
	}

	/**
	 * Returns the sharpness attribute of the associated text field.
	 * 
	 * @return The sharpness attribute of the associated text field.
	 */
	public Float32 getSharpness() {
		return sharpness;
	}

	public UINT16 getTextId() {
		return textId;
	}

	/**
	 * Returns the thickness attribute of the associated text field.
	 * 
	 * @return The thickness attribute of the associated text field.
	 */
	public Float32 getThickness() {
		return thickness;
	}

	/**
	 * Returns the rendering engine flag.
	 * 
	 * @return The rendering engine flag.
	 */
	public Bits getUseFlashType() {
		return useFlashType;
	}
}