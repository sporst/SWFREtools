package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.Float32;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a CSMTextSettings tag.
 */
public final class CSMTextSettingsTag extends Tag {

	/**
	 * ID for the text to which this tag applies.
	 */
	private final UINT16 textId;

	/**
	 * Rendering engine flag.
	 */
	private final UBits useFlashType;

	/**
	 * Grid fitting flag.
	 */
	private final UBits gridFit;

	/**
	 * First reserved bit field.
	 */
	private final UBits reserved;

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
			final UBits useFlashType, final UBits gridFit, final UBits reserved, final Float32 thickness,
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
	public UBits getGridFit() {
		return gridFit;
	}

	/**
	 * Returns the first reserved bit field.
	 * 
	 * @return The first reserved bit field.
	 */
	public UBits getReserved() {
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

	/**
	 * Returns the ID for the text to which this tag applies.
	 * 
	 * @return The ID for the text to which this tag applies.
	 */
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
	public UBits getUseFlashType() {
		return useFlashType;
	}
}