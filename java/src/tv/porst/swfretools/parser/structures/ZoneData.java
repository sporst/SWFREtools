package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Float16;

/**
 * Represents a ZoneData structure.
 * 
 * @author sp
 *
 */
public final class ZoneData implements IFileElement {

	/**
	 * X or Y coordinate of the alignment zone.
	 */
	private final Float16 alignmentCoordinate;

	/**
	 * Width or height of the alignment zone.
	 */
	private final Float16 range;

	/**
	 * Creates a new ZoneData object.
	 * 
	 * @param alignmentCoordinate X or Y coordinate of the alignment zone.
	 * @param range Width or height of the alignment zone.
	 */
	public ZoneData(final Float16 alignmentCoordinate, final Float16 range) {

		this.alignmentCoordinate = alignmentCoordinate;
		this.range = range;

	}

	/**
	 * Returns the X or Y coordinate of the alignment zone.
	 *
	 * @return The X or Y coordinate of the alignment zone.
	 */
	public Float16 getAlignmentCoordinate() {
		return alignmentCoordinate;
	}

	@Override
	public int getBytePosition() {
		return alignmentCoordinate.getBytePosition();
	}

	/**
	 * Returns the width or height of the alignment zone.
	 *
	 * @return The width or height of the alignment zone.
	 */
	public Float16 getRange() {
		return range;
	}
}