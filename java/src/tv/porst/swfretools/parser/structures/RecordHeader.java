package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.INT32;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a RecordHeader structure.
 * 
 * @author sp
 *
 */
public final class RecordHeader implements IFileElement {

	/**
	 * Type and length packed together.
	 */
	private final UINT16 tagCodeAndLength;

	/**
	 * Additional length field of tag.
	 */
	private final INT32 length;

	/**
	 * Creates a new RecordHeader object.
	 * 
	 * @param tagCodeAndLength Type and length packed together.
	 * @param length Additional length field of tag.
	 */
	public RecordHeader(final UINT16 tagCodeAndLength, final INT32 length) {

		this.tagCodeAndLength = tagCodeAndLength;
		this.length = length;

	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(tagCodeAndLength, length);
	}

	@Override
	public int getBitPosition() {
		return tagCodeAndLength.getBitPosition();
	}

	/**
	 * Returns the optional length field.
	 * 
	 * @return The optional length field.
	 */
	public INT32 getExtraLength() {
		return length;
	}

	/**
	 * Returns the length of the record header structure in bytes.
	 * 
	 * @return The length of the record header structure in bytes.
	 */
	public int getHeaderLength() {
		return length == null ? 2 : 2 + 4;
	}

	/**
	 * Returns the length of the record header as specified in the TagCodeAndLength field.
	 * 
	 * @return The length of the record header as specified in the TagCodeAndLength field.
	 */
	public int getLength() {
		return tagCodeAndLength.value() & 0x3F;
	}

	/**
	 * Returns the length of the tag with consideration of the additional length field.
	 * 
	 * @return The length of the tag with consideration of the additional length field.
	 */
	public int getNormalizedLength() {
		return getLength() == 0x3F ? length.value() : getLength();
	}

	/**
	 * Returns the TagCodeAndLength field.
	 * 
	 * @return The TagCodeAndLength field.
	 */
	public UINT16 getTagAndLength() {
		return tagCodeAndLength;
	}

	/**
	 * Returns the tag code of the record header structure.
	 * 
	 * @return The tag code of the record header structure.
	 */
	public int getTagCode() {
		return tagCodeAndLength.value() >>> 6;
	}
}