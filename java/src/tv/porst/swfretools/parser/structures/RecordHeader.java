package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.INT32;
import tv.porst.splib.io.UINT16;

public class RecordHeader {

	private final UINT16 tagCodeAndLength;
	private final INT32 length;

	public RecordHeader(final UINT16 tagCodeAndLength, final INT32 length) {
		this.tagCodeAndLength = tagCodeAndLength;
		this.length = length;
	}

	public int getHeaderLength() {
		return length == null ? UINT16.LENGTH : UINT16.LENGTH + INT32.LENGTH;
	}

	public int getLength() {
		return tagCodeAndLength.value() & 0x3F;
	}

	public int getNormalizedLength() {
		return getLength() == 0x3F ? length.value() : getLength();
	}

	public int getPosition() {
		return tagCodeAndLength.getPosition();
	}

	public UINT16 getTagAndLength() {
		return tagCodeAndLength;
	}

	public int getTagCode() {
		return tagCodeAndLength.value() >>> 6;
	}

}
